package com.kangyonggan.app.myth.web.controller.web;

import com.github.pagehelper.PageInfo;
import com.kangyonggan.app.myth.biz.service.ArticleService;
import com.kangyonggan.app.myth.biz.service.DictionaryService;
import com.kangyonggan.app.myth.model.constants.DictionaryType;
import com.kangyonggan.app.myth.model.vo.Article;
import com.kangyonggan.app.myth.model.vo.Dictionary;
import com.kangyonggan.app.myth.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author kangyonggan
 * @since 2016/12/22
 */
@Controller
@RequestMapping("/")
public class IndexController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private DictionaryService dictionaryService;

    /**
     * 网站模板
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String web() {
        return "web/web";
    }

    /**
     * 网站首页
     *
     * @param tag
     * @param pageNum
     * @param model
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(@RequestParam(value = "p", required = false, defaultValue = "1") int pageNum,
                        @RequestParam(value = "tag", required = false, defaultValue = "") String tag,
                        Model model) {
        List<Dictionary> tags = dictionaryService.findDictionariesByType(DictionaryType.TAG.getType());
        List<Article> articles = articleService.findArticlesByTag(pageNum, tag);
        PageInfo<Article> page = new PageInfo(articles);

        model.addAttribute("page", page);
        model.addAttribute("tags", tags);
        return getPathIndex();
    }

    @RequestMapping(value = "error/404", method = RequestMethod.GET)
    public String error404() {
        return "redirect:/#404";
    }

    @RequestMapping(value = "404", method = RequestMethod.GET)
    public String page404() {
        return "404";
    }

}
