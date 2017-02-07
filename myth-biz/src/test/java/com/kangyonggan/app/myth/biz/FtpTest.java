package com.kangyonggan.app.myth.biz;

import com.kangyonggan.app.myth.biz.util.Ftp;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author kangyonggan
 * @since 2017/1/21
 */
public class FtpTest extends AbstractServiceTest {

    @Autowired
    private Ftp ftp;

    @Test
    public void testUpload() {
        String name = ftp.upload("upload/20170121212403117.png");
        System.out.println(name);
    }

}
