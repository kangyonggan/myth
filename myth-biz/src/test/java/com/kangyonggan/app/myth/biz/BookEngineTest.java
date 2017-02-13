package com.kangyonggan.app.myth.biz;

import com.kangyonggan.app.myth.biz.engine.BookEngine;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author kangyonggan
 * @since 2017/2/11
 */
@Log4j2
public class BookEngineTest extends AbstractServiceTest {

    @Autowired
    private BookEngine bookEngine;

    @Test
    public void testExecute() {
        bookEngine.execute();
    }

    @Test
    public void testUpdateBookNewChaper() {
        bookEngine.updateBookNewChaper();
    }
}
