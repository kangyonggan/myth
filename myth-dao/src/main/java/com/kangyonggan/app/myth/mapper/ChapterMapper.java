package com.kangyonggan.app.myth.mapper;

import com.kangyonggan.app.myth.model.vo.Chapter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChapterMapper extends MyMapper<Chapter> {

    /**
     * 查找上一章节
     *
     * @param id
     * @param bookUrl
     * @return
     */
    Chapter findPrevChapter(@Param("id") Long id, @Param("bookUrl") String bookUrl);

    /**
     * 查找下一章节
     *
     * @param id
     * @param bookUrl
     * @return
     */
    Chapter findNextChapter(@Param("id") Long id, @Param("bookUrl") String bookUrl);
}