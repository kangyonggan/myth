package com.kangyonggan.app.myth.web.controller.dashboard;

import com.kangyonggan.app.myth.biz.service.SmsService;
import com.kangyonggan.app.myth.biz.service.TokenService;
import com.kangyonggan.app.myth.biz.service.UserService;
import com.kangyonggan.app.myth.model.constants.AppConstants;
import com.kangyonggan.app.myth.model.vo.Sms;
import com.kangyonggan.app.myth.model.vo.User;
import com.kangyonggan.app.myth.web.controller.BaseController;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Random;

/**
 * @author kangyonggan
 * @since 2017/2/9
 */
@Controller
@RequestMapping("dashboard/user/mobile")
@Log4j2
public class DashboardUserMobileController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private SmsService smsService;

    @Autowired
    private TokenService tokenService;

    /**
     * 手机认证
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @RequiresPermissions("USER_MOBILE")
    public String index(Model model) {
        User user = userService.findUserById(userService.getShiroUser().getId());

        String mobile = user.getMobile();
        if (StringUtils.isNotEmpty(mobile)) {
            user.setMobile(mobile.substring(0, 3) + "****" + mobile.substring(7, 11));
        }

        model.addAttribute("user", user);
        return getPathIndex();
    }

    /**
     * 修改手机
     *
     * @return
     */
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    @RequiresPermissions("USER_MOBILE")
    public String edit() {
        return getPathForm();
    }

    /**
     * 发送校验码
     *
     * @param mobile
     * @param captcha
     * @param request
     * @return
     */
    @RequestMapping(value = "send", method = RequestMethod.GET)
    @RequiresPermissions("USER_MOBILE")
    @ResponseBody
    public Map<String, Object> send(@RequestParam("mobile") String mobile,
                                    @RequestParam("captcha") String captcha,
                                    HttpServletRequest request) {
        Map<String, Object> resultMap = getResultMap();

        HttpSession session = request.getSession();
        String realCaptcha = (String) session.getAttribute(AppConstants.KEY_CAPTCHA);
        log.info("session中的验证码为：{}", realCaptcha);
        log.info("用户上送的验证码为：{}", captcha);

        if (!captcha.equalsIgnoreCase(realCaptcha)) {
            setResultMapFailure(resultMap, "验证码错误或已失效");
            return resultMap;
        }

        if (StringUtils.isEmpty(mobile)) {
            setResultMapFailure(resultMap, "手机号不能为空！");
            return resultMap;
        }

        User user = userService.findUserByMobile(mobile);
        if (user != null) {
            setResultMapFailure(resultMap, "该手机已被他人绑定！");
            return resultMap;
        }

        String regex = "^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$";
        if (!mobile.matches(regex)) {
            setResultMapFailure(resultMap, "手机号码不正确！");
            return resultMap;
        }

        // 清除验证码
        session.removeAttribute(AppConstants.KEY_CAPTCHA);

        // 发短信
        String code = tokenService.genTokenCode();
        smsService.sendSms(mobile, code, genToken());

        resultMap.put("code", code);
        return resultMap;
    }

    /**
     * 更新手机
     *
     * @param mobile
     * @param code
     * @param token
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @RequiresPermissions("USER_MOBILE")
    @ResponseBody
    public Map<String, Object> update(@RequestParam("mobile") String mobile,
                                      @RequestParam("code") String code,
                                      @RequestParam("token") String token) {
        Map<String, Object> resultMap = getResultMap();

        User user = userService.findUserById(userService.getShiroUser().getId());

        Sms sms = smsService.findSmsByCodeAndToken(code, token);
        if (sms != null) {
            sms.setIsDeleted(AppConstants.IS_DELETED_YES);
            smsService.updateSms(sms);
            user.setMobile(mobile);
            userService.updateUser(user);
        } else {
            setResultMapFailure(resultMap, "短信校验码不正确或已失效");
        }

        return resultMap;
    }

    private String genToken() {
        Random random = new Random();
        StringBuilder token = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            // 随机产生校验码码 0 ~ 9
            String code = String.valueOf(random.nextInt(10));
            // 拼接验证码
            token.append(code);
        }

        return token.toString();
    }

}
