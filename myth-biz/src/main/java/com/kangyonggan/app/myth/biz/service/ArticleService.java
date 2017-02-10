package com.kangyonggan.app.myth.biz.service;

import com.kangyonggan.app.myth.model.vo.Article;
import com.kangyonggan.app.myth.model.vo.Attachment;

import java.util.List;

/**
 * @author kangyonggan
 * @since 2017/2/9
 */
public interface ArticleService {

    /**
     * 搜索文章
     *
     * @param pageNum
     * @param username
     * @param tag
     * @param title
     * @return
     */
    List<Article> searchArticles(int pageNum, String username, String tag, String title);

    /**
     * 保存文章及附件
     *
     * @param article
     * @param attachments
     */
    void saveArticleWithAttachments(Article article, List<Attachment> attachments);

    /**
     * 更新文章
     *
     * @param article
     */
    void updateArticle(Article article);

    /**
     * 更新文章
     *
     * @param article
     * @param attachments
     */
    void updateArticleWithAttachments(Article article, List<Attachment> attachments);

    /**
     * 查找文章（包括逻辑删除）
     *
     * @param id
     * @return
     */
    Article getArticle(Long id);

    /**
     * 查找文章（不包括逻辑删除）
     *
     * @param id
     * @return
     */
    Article findArticleById(Long id);

    /**
     * 删除文章
     *
     * @param id
     */
    void deleteArticle(Long id);

    /**
     * 根据标签查找文章
     *
     * @param pageNum
     * @param tag
     * @return
     */
    List<Article> findArticlesByTag(int pageNum, String tag);

    /**
     * 查找所有文章
     *
     * @return
     */
    List<Article> findAllArticles();

}
