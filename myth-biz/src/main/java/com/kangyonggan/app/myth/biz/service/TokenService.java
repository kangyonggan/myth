package com.kangyonggan.app.myth.biz.service;

import com.kangyonggan.app.myth.model.vo.Token;

/**
 * @author kangyonggan
 * @since 2017/1/19
 */
public interface TokenService {

    /**
     * 保存记号
     *
     * @param type
     * @param userId
     * @return
     */
    String saveToken(String type, Long userId);

    /**
     * 根据代码查找记号
     *
     * @param code
     * @return
     */
    Token findTokenByCode(String code);

    /**
     * 更新记号
     *
     * @param token
     */
    void updateToken(Token token);
}
