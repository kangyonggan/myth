package com.kangyonggan.app.myth.biz.service;

import com.kangyonggan.app.myth.model.vo.Chapter;

import java.util.List;

/**
 * @author kangyonggan
 * @since 2017/2/12
 */
public interface ChapterService {

    /**
     * 保存章节
     *
     * @param chapter
     */
    void saveChapter(Chapter chapter);

    /**
     * 删除书籍的所有章节
     *
     * @param bookUrl
     */
    void deleteChaptersByBookUrl(String bookUrl);

    /**
     * 查找书籍章节
     *
     * @param bookUrl
     * @return
     */
    List<Chapter> findChaptersByBookUrl(String bookUrl);
}
