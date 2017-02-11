package com.kangyonggan.app.myth.web.controller.web;

import com.kangyonggan.app.myth.biz.engine.BookEngine;
import com.kangyonggan.app.myth.biz.engine.ChapterEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangyonggan
 * @since 2017/2/11
 */
@RestController
@RequestMapping("engine")
public class EngineController {

    @Autowired
    private BookEngine bookEngine;

    @Autowired
    private ChapterEngine chapterEngine;

    /**
     * 更新书籍
     */
    @RequestMapping(value = "book", method = RequestMethod.GET)
    public void updateBook() {
        bookEngine.execute();
    }

    /**
     * 更新章节
     *
     * @param categoryCode
     * @param bookUrl
     */
    @RequestMapping(value = "chapter", method = RequestMethod.GET)
    public void updateChapter(@RequestParam(value = "categoryCode", required = false, defaultValue = "") String categoryCode,
                              @RequestParam(value = "bookUrl", required = false, defaultValue = "") String bookUrl) {
        chapterEngine.execute(categoryCode, bookUrl);
    }

}
