package com.kangyonggan.app.myth.web.controller.dashboard;

import com.github.pagehelper.PageInfo;
import com.kangyonggan.app.myth.biz.service.*;
import com.kangyonggan.app.myth.biz.util.Collections3;
import com.kangyonggan.app.myth.biz.util.MarkdownUtil;
import com.kangyonggan.app.myth.model.constants.DictionaryType;
import com.kangyonggan.app.myth.model.vo.*;
import com.kangyonggan.app.myth.web.controller.BaseController;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author kangyonggan
 * @since 2017/2/9
 */
@Controller
@RequestMapping("dashboard/user/article")
public class DashboardUserArticleController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private UserService userService;

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private DictionaryMediService dictionaryMediService;

    /**
     * 文章列表
     *
     * @param pageNum
     * @param tag
     * @param title
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @RequiresPermissions("USER_ARTICLE")
    public String list(@RequestParam(value = "p", required = false, defaultValue = "1") int pageNum,
                       @RequestParam(value = "tag", required = false, defaultValue = "") String tag,
                       @RequestParam(value = "title", required = false, defaultValue = "") String title,
                       Model model) {
        ShiroUser user = userService.getShiroUser();
        List<Article> articles = articleService.searchArticles(pageNum, user.getUsername(), tag, title);
        PageInfo<Article> page = new PageInfo(articles);
        List<Dictionary> tags = dictionaryService.findDictionariesByType(DictionaryType.TAG.getType());

        model.addAttribute("page", page);
        model.addAttribute("tags", tags);
        return getPathList();
    }

    /**
     * 发布
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "create", method = RequestMethod.GET)
    @RequiresPermissions("USER_ARTICLE")
    public String create(Model model) {
        Article article = new Article();
        List<Dictionary> allTags = dictionaryService.findDictionariesByType(DictionaryType.TAG.getType());

        model.addAttribute("article", article);
        model.addAttribute("allTags", allTags);
        return getPathForm();
    }

    /**
     * 保存
     *
     * @param article
     * @param files
     * @param result
     * @return
     * @throws FileUploadException
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @RequiresPermissions("USER_ARTICLE")
    @ResponseBody
    public Map<String, Object> save(@ModelAttribute("article") @Valid Article article,
                                    @RequestParam(value = "file[]", required = false) List<MultipartFile> files,
                                    BindingResult result) throws FileUploadException {
        Map<String, Object> resultMap = getResultMap();
        ShiroUser shiroUser = userService.getShiroUser();

        if (!result.hasErrors()) {
            List<Attachment> attachments = new ArrayList();
            if (files != null && !files.isEmpty()) {
                attachments = uploadFiles(shiroUser.getUsername(), "article", files);
            }

            articleService.saveArticleWithAttachments(article, attachments);
        } else {
            setResultMapFailure(resultMap);
        }

        return resultMap;
    }

    /**
     * 编辑
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "{id:[\\d]+}/edit", method = RequestMethod.GET)
    @RequiresPermissions("USER_ARTICLE")
    public String edit(@PathVariable("id") Long id, Model model) {
        Article article = articleService.getArticle(id);
        List<Dictionary> allTags = dictionaryService.findDictionariesByType(DictionaryType.TAG.getType());
        List<DictionaryMedi> tags = dictionaryMediService.findDictionaryMedisBySourceIdAndType(id, DictionaryType.TAG.getType());
        List<Attachment> attachments = attachmentService.findAttachmentsBySourceIdAndType(id, "article");

        model.addAttribute("article", article);
        model.addAttribute("allTags", allTags);
        model.addAttribute("tags", Collections3.extractToList(tags, "dictionaryCode"));
        model.addAttribute("attachments", attachments);
        return getPathForm();
    }

    /**
     * 更新
     *
     * @param article
     * @param files
     * @param result
     * @return
     * @throws FileUploadException
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @RequiresPermissions("USER_ARTICLE")
    @ResponseBody
    public Map<String, Object> update(@ModelAttribute("article") @Valid Article article,
                                      @RequestParam(value = "file[]", required = false) List<MultipartFile> files,
                                      BindingResult result) throws FileUploadException {
        Map<String, Object> resultMap = getResultMap();
        ShiroUser shiroUser = userService.getShiroUser();

        if (!result.hasErrors()) {
            List<Attachment> attachments = new ArrayList();
            if (files != null && !files.isEmpty()) {
                attachments = uploadFiles(shiroUser.getUsername(), "article", files);
            }

            articleService.updateArticleWithAttachments(article, attachments);
        } else {
            setResultMapFailure(resultMap);
        }

        return resultMap;
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
    @RequiresPermissions("USER_ARTICLE")
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
    @RequiresPermissions("USER_ARTICLE")
    public Map<String, Object> remove(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);
        return getResultMap();
    }

    /**
     * 删除附件
     *
     * @param id
     * @param aid
     * @return
     */
    @RequestMapping(value = "{id:[\\d]+}/attachment/{aid:[\\d]+}/delete", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions("USER_ARTICLE")
    public Map<String, Object> deleteAttachment(@PathVariable("id") Long id, @PathVariable("aid") Long aid) {
        attachmentService.deleteAttachment(aid, id, "article");
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
    @RequiresPermissions("USER_ARTICLE")
    public String detail(@PathVariable("id") Long id, Model model) {
        Article article = articleService.getArticle(id);
        article.setContent(MarkdownUtil.markdownToHtml(article.getContent()));
        List<Attachment> attachments = attachmentService.findAttachmentsBySourceIdAndType(id, "article");

        model.addAttribute("article", article);
        model.addAttribute("attachments", attachments);
        return "web/article/detail";
    }
}
