package com.kangyonggan.app.myth.web.controller.web;

import com.kangyonggan.app.myth.biz.engine.BookEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    /**
     * 更新书籍
     */
    @RequestMapping(value = "book", method = RequestMethod.GET)
    public void updateBook() {
        bookEngine.execute();
    }

}
