package com.kangyonggan.app.myth.biz;

import com.kangyonggan.app.myth.biz.service.SmsService;
import com.kangyonggan.app.myth.biz.util.DateUtils;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author kangyonggan
 * @since 2017/2/9
 */
@Log4j2
public class SmsTest extends AbstractServiceTest {

    @Autowired
    private SmsService smsService;

    @Test
    public void testSendSms() {
        Map<String, Object> resultMap = smsService.sendSms("13062666053", DateUtils.getCurrentFullDateTime(), "123456");
        log.info(resultMap);
    }

}
