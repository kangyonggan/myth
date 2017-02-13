package com.kangyonggan.app.myth.web.controller.web;

import com.kangyonggan.app.myth.biz.engine.BookEngine;
import com.kangyonggan.app.myth.biz.engine.ChapterEngine;
import com.kangyonggan.app.myth.biz.service.DictionaryService;
import com.kangyonggan.app.myth.model.constants.DictionaryType;
import com.kangyonggan.app.myth.model.vo.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private DictionaryService dictionaryService;

    /**
     * 更新书籍
     */
    @RequestMapping(value = "book", method = RequestMethod.GET)
    public void updateBook() {
        bookEngine.execute();
    }

    /**
     * 更新书籍
     */
    @RequestMapping(value = "book/{url:[\\d]+}", method = RequestMethod.GET)
    public void updateBook(@PathVariable("url") String url) {
        Dictionary category = dictionaryService.findDictionaryByCodeAndType("qita", DictionaryType.BOOK.getType());
        bookEngine.updateBook(url, category);
    }

    /**
     * 更新书籍
     */
    @RequestMapping(value = "book/new/chapter", method = RequestMethod.GET)
    public void updateBookChapter(@RequestParam(value = "categoryCode", required = false, defaultValue = "") String categoryCode,
                                  @RequestParam(value = "bookUrl", required = false, defaultValue = "") String bookUrl) {
        bookEngine.updateBookNewChaper(categoryCode, bookUrl);
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
