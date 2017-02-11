package com.kangyonggan.app.myth.biz;

import com.kangyonggan.app.myth.biz.engine.ChapterEngine;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author kangyonggan
 * @since 2017/2/11
 */
@Log4j2
public class ChapterEngineTest extends AbstractServiceTest {

    @Autowired
    private ChapterEngine chapterEngine;

    @Test
    public void testExecute() {
        chapterEngine.execute(null, null);
    }
}
