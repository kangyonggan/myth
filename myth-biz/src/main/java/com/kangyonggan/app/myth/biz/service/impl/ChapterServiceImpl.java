package com.kangyonggan.app.myth.biz.service.impl;

import com.kangyonggan.app.myth.biz.service.ChapterService;
import com.kangyonggan.app.myth.model.annotation.LogTime;
import com.kangyonggan.app.myth.model.vo.Chapter;
import org.springframework.stereotype.Service;

/**
 * @author kangyonggan
 * @since 2017/2/12
 */
@Service
public class ChapterServiceImpl extends BaseService<Chapter> implements ChapterService {

    @Override
    @LogTime
    public void saveChapter(Chapter chapter) {
        super.insertSelective(chapter);
    }

    @Override
    @LogTime
    public void deleteChaptersByBookUrl(String bookUrl) {
        Chapter chapter = new Chapter();
        chapter.setBookUrl(bookUrl);

        super.delete(chapter);
    }
}
