package com.kangyonggan.app.myth.biz.service;

import com.kangyonggan.app.myth.model.vo.Sms;

import java.util.List;
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

    /**
     * 短信查询
     *
     * @param pageNum
     * @param mobile
     * @return
     */
    List<Sms> searchSmses(int pageNum, String mobile);

    /**
     * 查找短信
     *
     * @param code
     * @param token
     * @return
     */
    Sms findSmsByCodeAndToken(String code, String token);

    /**
     * 更新短信
     *
     * @param sms
     */
    void updateSms(Sms sms);
}
