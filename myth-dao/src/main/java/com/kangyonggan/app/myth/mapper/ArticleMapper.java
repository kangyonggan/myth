package com.kangyonggan.app.myth.mapper;

import com.kangyonggan.app.myth.model.vo.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper extends MyMapper<Article> {

    /**
     * 搜索文章
     *
     * @param username
     * @param tag
     * @param title
     * @return
     */
    List<Article> searchArticles(@Param("username") String username, @Param("tag") String tag, @Param("title") String title);

    /**
     * 根据标签查找文章
     *
     * @param tag
     * @return
     */
    List<Article> findArticlesByTag(@Param("tag") String tag);
}