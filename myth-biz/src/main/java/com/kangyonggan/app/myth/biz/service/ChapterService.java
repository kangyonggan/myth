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

    /**
     * 查找章节
     *
     * @param id
     * @return
     */
    Chapter findChapterById(Long id);

    /**
     * 查找上一章节
     *
     * @param id
     * @param bookUrl
     * @return
     */
    Chapter findPrevChapter(Long id, String bookUrl);

    /**
     * 查找下一章节
     *
     * @param id
     * @param bookUrl
     * @return
     */
    Chapter findNextChapter(Long id, String bookUrl);

    /**
     * 查找最新章节
     *
     * @param url
     * @return
     */
    Chapter findNewChapter(String url);
}
