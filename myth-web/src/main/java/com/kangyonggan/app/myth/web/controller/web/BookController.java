package com.kangyonggan.app.myth.web.controller.web;

import com.kangyonggan.app.myth.biz.service.DictionaryService;
import com.kangyonggan.app.myth.model.constants.DictionaryType;
import com.kangyonggan.app.myth.model.vo.Dictionary;
import com.kangyonggan.app.myth.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author kangyonggan
 * @since 2017/2/10
 */
@Controller
@RequestMapping("book")
public class BookController extends BaseController {

    @Autowired
    private DictionaryService dictionaryService;

    /**
     * 书籍首页
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Dictionary> categories = dictionaryService.findDictionariesByType(DictionaryType.BOOK.getType());

        model.addAttribute("categories", categories);
        return getPathIndex();
    }

}
