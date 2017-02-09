package com.kangyonggan.app.myth.mapper;

import com.kangyonggan.app.myth.model.vo.Sms;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SmsMapper extends MyMapper<Sms> {

    /**
     * 查找短信
     *
     * @param code
     * @param token
     * @return
     */
    Sms findSmsByCodeAndToken(@Param("code") String code, @Param("token") String token);
}