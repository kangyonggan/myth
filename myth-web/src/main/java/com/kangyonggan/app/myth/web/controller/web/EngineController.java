package com.kangyonggan.app.myth.web.controller.web;

import com.kangyonggan.app.myth.biz.engine.BookEngine;
import com.kangyonggan.app.myth.biz.engine.ChapterEngine;
import com.kangyonggan.app.myth.biz.service.BookService;
import com.kangyonggan.app.myth.biz.service.DictionaryService;
import com.kangyonggan.app.myth.model.constants.DictionaryType;
import com.kangyonggan.app.myth.model.vo.Dictionary;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author kangyonggan
 * @since 2017/2/11
 */
@RestController
@RequestMapping("engine")
@Log4j2
public class EngineController {

    @Autowired
    private BookEngine bookEngine;

    @Autowired
    private ChapterEngine chapterEngine;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private BookService bookService;

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
    public String updateChapter(@RequestParam(value = "categoryCode", required = false, defaultValue = "") String categoryCode,
                              @RequestParam(value = "bookUrl", required = false, defaultValue = "") String bookUrl) {
        new Thread(){
            @Override
            public void run() {
                chapterEngine.execute(categoryCode, bookUrl);
            }
        }.start();
        return "正在拉取章节，可能需要一些时间，请稍后查看！";
    }

    /**
     * 初始化，解锁+校正
     */
    @RequestMapping(method = RequestMethod.GET)
    public void init() {
        // 1. 解锁
        bookService.updateAllLocks();
        log.info("所有书籍已解锁");

        // 2. 更新最新章节
        bookEngine.updateBookNewChaper(null, null);
    }

}
