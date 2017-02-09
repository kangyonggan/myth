package com.kangyonggan.app.myth.biz.service.impl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;
import com.github.pagehelper.PageHelper;
import com.kangyonggan.app.myth.biz.service.SmsService;
import com.kangyonggan.app.myth.biz.util.PropertiesUtil;
import com.kangyonggan.app.myth.mapper.SmsMapper;
import com.kangyonggan.app.myth.model.annotation.LogTime;
import com.kangyonggan.app.myth.model.constants.AppConstants;
import com.kangyonggan.app.myth.model.vo.Sms;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author kangyonggan
 * @since 2017/2/9
 */
@Log4j2
public class SmsServiceImpl extends BaseService<Sms> implements SmsService {

    @Setter
    private String regionId;

    @Setter
    private String accessKeyId;

    @Setter
    private String secret;

    @Setter
    private String domain;

    @Setter
    private String signName;

    @Setter
    private String templateCode;

    @Setter
    private String debug;

    private IAcsClient client;

    @Autowired
    private SmsMapper smsMapper;

    public SmsServiceImpl() {
        try {
            IClientProfile profile = DefaultProfile.getProfile(regionId, accessKeyId, secret);
            DefaultProfile.addEndpoint(regionId, regionId, "Sms", domain);
            client = new DefaultAcsClient(profile);
        } catch (Exception e) {
            log.error("初始化短信配置失败", e);
        }
    }

    @Override
    @LogTime
    public Map<String, Object> sendSms(String mobile, String code, String token) {
        // 准备返回结果
        Map<String, Object> resultMap = new HashedMap();
        resultMap.put("mobile", mobile);

        String errCo;
        String errMsg;

        // 基础校验
        if (StringUtils.isEmpty(mobile)) {
            errCo = "1001";
            errMsg = "手机号码不能为空";

            resultMap.put("errCo", errCo);
            resultMap.put("errMsg", errMsg);
            saveSms(code, mobile, token, errCo, errMsg, null);
            return resultMap;
        }

        String regex = "^(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$";
        if (!mobile.matches(regex)) {
            errCo = "1002";
            errMsg = "手机号码不正确";

            resultMap.put("errCo", errCo);
            resultMap.put("errMsg", errMsg);
            saveSms(code, mobile, token, errCo, errMsg, null);
            return resultMap;
        }

        if (StringUtils.isEmpty(code)) {
            errCo = "1003";
            errMsg = "短信码不能为空";

            resultMap.put("errCo", errCo);
            resultMap.put("errMsg", errMsg);
            saveSms(code, mobile, token, errCo, errMsg, null);
            return resultMap;
        }
        if (StringUtils.isEmpty(token)) {
            errCo = "1004";
            errMsg = "验证码不能为空";

            resultMap.put("errCo", errCo);
            resultMap.put("errMsg", errMsg);
            saveSms(code, mobile, token, errCo, errMsg, null);
            return resultMap;
        }
        if (token.length() != 6) {
            errCo = "1005";
            errMsg = "验证码长度不正确";

            resultMap.put("errCo", errCo);
            resultMap.put("errMsg", errMsg);
            saveSms(code, mobile, token, errCo, errMsg, null);
            return resultMap;
        }

        // 发送
        try {
            SingleSendSmsRequest request = new SingleSendSmsRequest();
            request.setSignName(signName);
            request.setTemplateCode(templateCode);
            request.setParamString("{\"token\":\"" + token + "\"}");
            request.setRecNum(mobile);

            SingleSendSmsResponse response;
            if (!"true".equals(debug)) {
                response = client.getAcsResponse(request);
            } else {
                log.info("调试阶段不真正的发短信");
                response = new SingleSendSmsResponse();
                response.setRequestId("BFDBE6CE-C2C5-46C0-8EC6-8A6628AAF53F");
                response.setModel("105862070614^1107954709798");
            }
            log.info("请求ID:{}", response.getRequestId());
            log.info("响应结果:{}", response.getModel());
            log.info("短信发送成功, 接收号码:{}, 验证码为:{}", mobile, token);

            errCo = "0000";
            errMsg = "发送成功";

            resultMap.put("errCo", errCo);
            resultMap.put("errMsg", errMsg);
            saveSms(code, mobile, token, errCo, errMsg, response);
            return resultMap;
        } catch (Exception e) {
            log.error("短信发送失败, 接收号码:" + mobile + ", 验证码:" + token, e);
            errCo = "9999";
            errMsg = "发送失败，请稍后再试!";

            resultMap.put("errCode", errCo);
            resultMap.put("errMsg", errMsg);
            saveSms(code, mobile, token, errCo, errMsg, null);
            return resultMap;
        }
    }

    @Override
    @LogTime
    public List<Sms> searchSmses(int pageNum, String mobile) {
        Example example = new Example(Sms.class);
        if (StringUtils.isNotEmpty(mobile)) {
            example.createCriteria().andEqualTo("mobile", mobile);
        }
        example.setOrderByClause("id desc");

        PageHelper.startPage(pageNum, AppConstants.PAGE_SIZE);
        return super.selectByExample(example);
    }

    @Override
    @LogTime
    public Sms findSmsByCodeAndToken(String code, String token) {
        return smsMapper.findSmsByCodeAndToken(code, token);
    }

    @Override
    @LogTime
    public void updateSms(Sms sms) {
        super.updateByPrimaryKeySelective(sms);
    }

    /**
     * 短信落库
     *
     * @param code
     * @param mobile
     * @param token
     * @param errCo
     * @param errMsg
     * @param response
     */
    private void saveSms(String code, String mobile, String token, String errCo, String errMsg, SingleSendSmsResponse response) {
        Sms sms = new Sms();
        sms.setCode(code);
        sms.setMobile(mobile);
        sms.setToken(token);
        sms.setErrCo(errCo);
        sms.setErrMsg(errMsg);
        if (response != null) {
            sms.setResult("{'requestId':'" + response.getRequestId() + "', 'model':'" + response.getModel() + "'}");
        }
        sms.setExpireTime(new Date(new Date().getTime() + 30 * 60 * 1000));// 30分钟

        super.insertSelective(sms);
        log.info("短信落库成功, {}", sms);
    }
}
