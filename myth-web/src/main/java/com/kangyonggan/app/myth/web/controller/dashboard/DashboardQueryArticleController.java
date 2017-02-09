package com.kangyonggan.app.myth.web.controller.dashboard;

import com.github.pagehelper.PageInfo;
import com.kangyonggan.app.myth.biz.service.ArticleService;
import com.kangyonggan.app.myth.biz.service.AttachmentService;
import com.kangyonggan.app.myth.biz.service.DictionaryService;
import com.kangyonggan.app.myth.biz.util.MarkdownUtil;
import com.kangyonggan.app.myth.model.constants.DictionaryType;
import com.kangyonggan.app.myth.model.vo.Article;
import com.kangyonggan.app.myth.model.vo.Attachment;
import com.kangyonggan.app.myth.model.vo.Dictionary;
import com.kangyonggan.app.myth.web.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author kangyonggan
 * @since 2017/2/9
 */
@Controller
@RequestMapping("dashboard/query/article")
public class DashboardQueryArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private AttachmentService attachmentService;

    /**
     * 文章列表
     *
     * @param pageNum
     * @param username
     * @param tag
     * @param title
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @RequiresPermissions("QUERY_ARTICLE")
    public String list(@RequestParam(value = "p", required = false, defaultValue = "1") int pageNum,
                       @RequestParam(value = "tag", required = false, defaultValue = "") String tag,
                       @RequestParam(value = "username", required = false, defaultValue = "") String username,
                       @RequestParam(value = "title", required = false, defaultValue = "") String title,
                       Model model) {
        List<Article> articles = articleService.searchArticles(pageNum, username, tag, title);
        PageInfo<Article> page = new PageInfo(articles);
        List<Dictionary> tags = dictionaryService.findDictionariesByType(DictionaryType.TAG.getType());

        model.addAttribute("page", page);
        model.addAttribute("tags", tags);
        return getPathList();
    }

    /**
     * 删除/恢复
     *
     * @param id
     * @param isDeleted
     * @param model
     * @return
     */
    @RequestMapping(value = "{id:[\\d]+}/{isDeleted:\\bundelete\\b|\\bdelete\\b}", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    @RequiresPermissions("QUERY_ARTICLE")
    public String delete(@PathVariable("id") Long id, @PathVariable("isDeleted") String isDeleted, Model model) {
        Article article = articleService.getArticle(id);
        article.setIsDeleted((byte) (isDeleted.equals("delete") ? 1 : 0));
        articleService.updateArticle(article);

        model.addAttribute("article", article);
        return getPathTableTr();
    }

    /**
     * 物理删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "{id:[\\d]+}/remove", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions("QUERY_ARTICLE")
    public Map<String, Object> remove(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);
        return getResultMap();
    }

    /**
     * 详情
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "{id:[\\d]+}", method = RequestMethod.GET)
    @RequiresPermissions("QUERY_ARTICLE")
    public String detail(@PathVariable("id") Long id, Model model) {
        Article article = articleService.getArticle(id);
        article.setContent(MarkdownUtil.markdownToHtml(article.getContent()));
        List<Attachment> attachments = attachmentService.findAttachmentsBySourceIdAndType(id, "article");

        model.addAttribute("article", article);
        model.addAttribute("attachments", attachments);
        model.addAttribute("isQuery", "true");
        return "web/article/detail";
    }
}
