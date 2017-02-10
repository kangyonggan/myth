package com.kangyonggan.app.myth.biz.service.impl;

import com.github.pagehelper.PageHelper;
import com.kangyonggan.app.myth.biz.service.*;
import com.kangyonggan.app.myth.biz.util.Collections3;
import com.kangyonggan.app.myth.mapper.ArticleMapper;
import com.kangyonggan.app.myth.model.annotation.LogTime;
import com.kangyonggan.app.myth.model.constants.AppConstants;
import com.kangyonggan.app.myth.model.constants.DictionaryType;
import com.kangyonggan.app.myth.model.vo.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Arrays;
import java.util.List;

/**
 * @author kangyonggan
 * @since 2017/2/9
 */
@Service
public class ArticleServiceImpl extends BaseService<Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private AttachmentService attachmentService;

    @Autowired
    private DictionaryMediService dictionaryMediService;

    @Override
    @LogTime
    public List<Article> searchArticles(int pageNum, String username, String tag, String title) {
        PageHelper.startPage(pageNum, AppConstants.PAGE_SIZE);
        return articleMapper.searchArticles(username, tag, title);
    }

    @Override
    @LogTime
    public void saveArticleWithAttachments(Article article, List<Attachment> attachments) {
        // 处理文章标签
        String tags = article.getTags();
        List<Dictionary> dictionaries = dictionaryService.findDictionariesByCodes(tags);
        article.setTags(Collections3.convertToString(Collections3.extractToList(dictionaries, "value"), " "));

        // 处理创建人
        User user = userService.findUserById(userService.getShiroUser().getId());
        article.setCreateUsername(user.getUsername());
        article.setCreateFullname(user.getFullname());

        // 保存文章
        super.insertSelective(article);

        // 保存标签
        dictionaryMediService.saveDictionaryMedis(article.getId(), DictionaryType.TAG.getType(), Arrays.asList(tags.split(",")));

        // 保存附件
        if (attachments != null && !attachments.isEmpty()) {
            attachmentService.saveAttachments(article.getId(), attachments);
        }
    }

    @Override
    @LogTime
    public void updateArticle(Article article) {
        // 处理文章标签
        String tags = article.getTags();
        if (StringUtils.isNotEmpty(tags)) {
            List<Dictionary> dictionaries = dictionaryService.findDictionariesByCodes(tags);
            article.setTags(Collections3.convertToString(Collections3.extractToList(dictionaries, "value"), " "));

            // 删除原有的标签
            dictionaryMediService.deleteDictionaryMedis(article.getId(), DictionaryType.TAG.getType());

            // 保存标签
            dictionaryMediService.saveDictionaryMedis(article.getId(), DictionaryType.TAG.getType(), Arrays.asList(tags.split(",")));
        }

        super.updateByPrimaryKeySelective(article);
    }

    @Override
    @LogTime
    public void updateArticleWithAttachments(Article article, List<Attachment> attachments) {
        updateArticle(article);

        // 保存附件
        if (attachments != null && !attachments.isEmpty()) {
            attachmentService.saveAttachments(article.getId(), attachments);
        }
    }

    @Override
    @LogTime
    public Article getArticle(Long id) {
        return super.selectByPrimaryKey(id);
    }

    @Override
    @LogTime
    public Article findArticleById(Long id) {
        Article article = new Article();
        article.setIsDeleted(AppConstants.IS_DELETED_NO);
        article.setId(id);

        return super.selectOne(article);
    }

    @Override
    @LogTime
    public void deleteArticle(Long id) {
        ShiroUser user = userService.getShiroUser();
        Article article = new Article();
        article.setId(id);
        article.setIsDeleted(AppConstants.IS_DELETED_YES);
        article.setCreateUsername(user.getUsername());

        super.delete(article);
    }

    @Override
    @LogTime
    public List<Article> findArticlesByTag(int pageNum, String tag) {
        PageHelper.startPage(pageNum, AppConstants.PAGE_SIZE);

        return articleMapper.findArticlesByTag(tag);
    }

    @Override
    @LogTime
    public List<Article> findAllArticles() {
        Example example = new Example(Article.class);
        example.createCriteria().andEqualTo("isDeleted", AppConstants.IS_DELETED_NO);

        example.setOrderByClause("id desc");
        return super.selectByExample(example);
    }
}
