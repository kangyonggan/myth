package com.kangyonggan.app.myth.biz.service.impl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;
import com.kangyonggan.app.myth.biz.service.SmsService;
import com.kangyonggan.app.myth.biz.util.PropertiesUtil;
import com.kangyonggan.app.myth.model.annotation.LogTime;
import com.kangyonggan.app.myth.model.vo.Sms;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
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

    private IAcsClient client;

    public SmsServiceImpl() {
        regionId = PropertiesUtil.getProperties("sms.regionId");
        accessKeyId = PropertiesUtil.getProperties("sms.accessKeyId");
        secret = PropertiesUtil.getProperties("sms.secret");
        domain = PropertiesUtil.getProperties("sms.domain");
        signName = PropertiesUtil.getProperties("sms.signName");
        templateCode = PropertiesUtil.getProperties("sms.templateCode");

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
        SingleSendSmsResponse response = null;
        try {
            SingleSendSmsRequest request = new SingleSendSmsRequest();
            request.setSignName(signName);
            request.setTemplateCode(templateCode);
            request.setParamString("{\"token\":\"" + token + "\"}");
            request.setRecNum(mobile);

            response = client.getAcsResponse(request);
            log.info("请求ID:{}", response.getRequestId());
            log.info("响应结果:{}", response.getModel());
            log.info("短信发送成功, 接收号码:{}, 验证码为:{}", mobile, token);

            errCo = "0000";
            errMsg = "发送成功";

            resultMap.put("errCo", errCo);
            resultMap.put("errMsg", errMsg);
            saveSms(code, mobile, token, errCo, errMsg, null);
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
