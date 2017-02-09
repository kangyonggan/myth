package com.kangyonggan.app.myth.biz.service;

import java.util.Map;

/**
 * @author kangyonggan
 * @since 2017/2/9
 */
public interface SmsService {

    /**
     * 发短信
     *
     * @param mobile
     * @param code
     * @param token
     */
    Map<String, Object> sendSms(String mobile, String code, String token);

}
