package com.kangyonggan.app.myth.web.controller.dashboard;

import com.github.pagehelper.PageInfo;
import com.kangyonggan.app.myth.biz.service.SmsService;
import com.kangyonggan.app.myth.model.vo.Sms;
import com.kangyonggan.app.myth.web.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author kangyonggan
 * @since 2017/2/9
 */
@Controller
@RequestMapping("dashboard/query/sms")
public class DashboardQuerySmsController extends BaseController {

    @Autowired
    private SmsService smsService;

    /**
     * 短信列表
     *
     * @param pageNum
     * @param mobile
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @RequiresPermissions("QUERY_SMS")
    public String list(@RequestParam(value = "p", required = false, defaultValue = "1") int pageNum,
                       @RequestParam(value = "mobile", required = false, defaultValue = "") String mobile,
                       Model model) {
        List<Sms> smses = smsService.searchSmses(pageNum, mobile);
        PageInfo<Sms> page = new PageInfo(smses);

        model.addAttribute("page", page);
        return getPathList();
    }


}
