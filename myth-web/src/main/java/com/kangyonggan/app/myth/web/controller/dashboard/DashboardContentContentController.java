package com.kangyonggan.app.myth.web.controller.dashboard;

import com.github.pagehelper.PageInfo;
import com.kangyonggan.app.myth.biz.service.AttachmentService;
import com.kangyonggan.app.myth.biz.service.ContentService;
import com.kangyonggan.app.myth.biz.service.DictionaryService;
import com.kangyonggan.app.myth.biz.service.UserService;
import com.kangyonggan.app.myth.model.constants.DictionaryType;
import com.kangyonggan.app.myth.model.vo.Attachment;
import com.kangyonggan.app.myth.model.vo.Content;
import com.kangyonggan.app.myth.model.vo.Dictionary;
import com.kangyonggan.app.myth.model.vo.ShiroUser;
import com.kangyonggan.app.myth.web.controller.BaseController;
import com.kangyonggan.app.myth.web.util.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @since 2017/1/21
 */
@Controller
@RequestMapping("dashboard/content/content")
public class DashboardContentContentController extends BaseController {

    @Autowired
    private ContentService contentService;

    @Autowired
    private UserService userService;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private AttachmentService attachmentService;

    /**
     * 列表界面
     *
     * @param pageNum
     * @param template
     * @param title
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    @RequiresPermissions("CONTENT_CONTENT")
    public String list(@RequestParam(value = "p", required = false, defaultValue = "1") int pageNum,
                       @RequestParam(value = "template", required = false, defaultValue = "") String template,
                       @RequestParam(value = "title", required = false, defaultValue = "") String title,
                       Model model) {
        List<Content> contents = contentService.searchContents(pageNum, template, title);
        PageInfo<Content> page = new PageInfo(contents);
        List<Dictionary> templates = dictionaryService.findDictionariesByType(DictionaryType.TEMPLATE.getType());

        model.addAttribute("page", page);
        model.addAttribute("templates", templates);
        return getPathList();
    }

    /**
     * 添加界面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "create", method = RequestMethod.GET)
    @RequiresPermissions("CONTENT_CONTENT")
    public String create(Model model) {
        model.addAttribute("content", new Content());
        model.addAttribute("templates", dictionaryService.findDictionariesByType(DictionaryType.TEMPLATE.getType()));
        return getPathForm();
    }

    /**
     * 保存内容
     *
     * @param files
     * @param content
     * @param result
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    @RequiresPermissions("CONTENT_CONTENT")
    @ResponseBody
    public Map<String, Object> save(@RequestParam(value = "file[]", required = false) List<MultipartFile> files,
                                    @ModelAttribute("content") @Valid Content content, BindingResult result) throws Exception {
        Map<String, Object> resultMap = getResultMap();
        ShiroUser shiroUser = userService.getShiroUser();

        if (!result.hasErrors()) {
            List<Attachment> attachments = null;
            if (files != null && !files.isEmpty()) {
                attachments = uploadFiles(shiroUser.getUsername(), "content", files);
            }

            contentService.saveContentWithAttachments(content, attachments);
        } else {
            setResultMapFailure(resultMap);
        }

        return resultMap;
    }

    /**
     * 编辑界面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "{id:[\\d]+}/edit", method = RequestMethod.GET)
    @RequiresPermissions("CONTENT_CONTENT")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("content", contentService.findContentById(id));
        model.addAttribute("attachments", attachmentService.findAttachmentsBySourceIdAndType(id, "content"));
        model.addAttribute("templates", dictionaryService.findDictionariesByType(DictionaryType.TEMPLATE.getType()));
        return getPathForm();
    }

    /**
     * 更新内容
     *
     * @param files
     * @param content
     * @param result
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @RequiresPermissions("CONTENT_CONTENT")
    @ResponseBody
    public Map<String, Object> update(@RequestParam(value = "file[]", required = false) List<MultipartFile> files,
                                      @ModelAttribute("content") @Valid Content content, BindingResult result) throws Exception {
        Map<String, Object> resultMap = getResultMap();
        ShiroUser shiroUser = userService.getShiroUser();

        if (!result.hasErrors()) {
            List<Attachment> attachments = null;
            if (files != null && !files.isEmpty()) {
                attachments = uploadFiles(shiroUser.getUsername(), "content", files);
            }

            contentService.updateContentWithAttachments(content, attachments);
        } else {
            setResultMapFailure(resultMap);
        }

        return resultMap;
    }

    /**
     * 物理删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "{id:[\\d]+}/delete", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions("CONTENT_CONTENT")
    public Map<String, Object> delete(@PathVariable("id") Long id) {
        contentService.deleteContent(id);
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
    @RequiresPermissions("CONTENT_CONTENT")
    public Map<String, Object> deleteAttachment(@PathVariable("id") Long id, @PathVariable("aid") Long aid) {
        attachmentService.deleteAttachment(aid, id, "content");
        return getResultMap();
    }
}
