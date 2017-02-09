package com.kangyonggan.app.myth.web.controller.web;

import com.kangyonggan.app.myth.biz.service.ArticleService;
import com.kangyonggan.app.myth.biz.service.AttachmentService;
import com.kangyonggan.app.myth.biz.util.MarkdownUtil;
import com.kangyonggan.app.myth.model.vo.Article;
import com.kangyonggan.app.myth.model.vo.Attachment;
import com.kangyonggan.app.myth.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author kangyonggan
 * @since 2016/12/18
 */
@Controller
@RequestMapping("article")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private AttachmentService attachmentService;

    /**
     * 文章详情
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "{id:[\\d]+}", method = RequestMethod.GET)
    public String detail(@PathVariable("id") Long id, Model model) {
        Article article = articleService.findArticleById(id);
        article.setContent(MarkdownUtil.markdownToHtml(article.getContent()));
        List<Attachment> attachments = attachmentService.findAttachmentsBySourceIdAndType(id, "article");

        model.addAttribute("article", article);
        model.addAttribute("attachments", attachments);
        return getPathDetail();
    }

}
