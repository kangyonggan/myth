package com.kangyonggan.app.myth.biz.impl;

import com.kangyonggan.app.myth.model.annotation.CacheDeleteAll;
import com.kangyonggan.app.myth.model.annotation.CacheGetOrSave;
import com.kangyonggan.app.myth.model.annotation.Param;
import com.kangyonggan.app.myth.model.constants.CommonErrors;
import com.kangyonggan.app.myth.model.dto.request.DemoRequest;
import com.kangyonggan.app.myth.model.dto.response.CommonResponse;
import com.kangyonggan.app.myth.service.CmsDemoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

/**
 * @author kangyonggan
 * @since 2017/1/18
 */
@Service("mythDemoService")
@Log4j2
public class CmsDemoServiceImpl implements CmsDemoService {

    @Override
    @CacheGetOrSave("demo:name:{0:name}")
    public CommonResponse hello(@Param(name = "request") DemoRequest request) {
        CommonResponse response = new CommonResponse();

        try {
            // TODO hello的业务逻辑
            log.info("hello的业务逻辑");

            response.setRespCode(CommonErrors.SUCCESS.getErrCode());
            response.setRespMsg(CommonErrors.SUCCESS.getErrMsg());
        } catch (Exception e) {
            log.error("调用hello接口报错", e);
            response.setRespCode(CommonErrors.UNKNOW_EXCEPTION.getErrCode());
            response.setRespMsg(CommonErrors.UNKNOW_EXCEPTION.getErrMsg());
        }

        return response;
    }

    @Override
    @CacheDeleteAll("demo:name")
    public CommonResponse world(String name, @Param(name = "value", min = 0, max = 99) int value) {
        CommonResponse response = new CommonResponse();

        try {
            // TODO world的业务逻辑
            log.info("world的业务逻辑");

            response.setRespCode(CommonErrors.SUCCESS.getErrCode());
            response.setRespMsg(CommonErrors.SUCCESS.getErrMsg());
        } catch (Exception e) {
            log.error("调用world接口报错", e);
            response.setRespCode(CommonErrors.UNKNOW_EXCEPTION.getErrCode());
            response.setRespMsg(CommonErrors.UNKNOW_EXCEPTION.getErrMsg());
        }

        return response;
    }
}
