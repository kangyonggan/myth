package com.kangyonggan.app.myth.biz.service.impl;

import com.kangyonggan.app.myth.biz.service.ChapterService;
import com.kangyonggan.app.myth.mapper.ChapterMapper;
import com.kangyonggan.app.myth.model.annotation.LogTime;
import com.kangyonggan.app.myth.model.constants.AppConstants;
import com.kangyonggan.app.myth.model.vo.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author kangyonggan
 * @since 2017/2/12
 */
@Service
public class ChapterServiceImpl extends BaseService<Chapter> implements ChapterService {

    @Autowired
    private ChapterMapper chapterMapper;

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

    @Override
    @LogTime
    public List<Chapter> findChaptersByBookUrl(String bookUrl) {
        Example example = new Example(Chapter.class);
        example.createCriteria().andEqualTo("bookUrl", bookUrl).andEqualTo("isDeleted", AppConstants.IS_DELETED_NO);

        example.setOrderByClause("id asc");
        return super.selectByExample(example);
    }

    @Override
    @LogTime
    public Chapter findChapterById(Long id) {
        return super.selectByPrimaryKey(id);
    }

    @Override
    @LogTime
    public Chapter findPrevChapter(Long id, String bookUrl) {
        return chapterMapper.findPrevChapter(id, bookUrl);
    }

    @Override
    @LogTime
    public Chapter findNextChapter(Long id, String bookUrl) {
        return chapterMapper.findNextChapter(id, bookUrl);
    }

    @Override
    @LogTime
    public Chapter findNewChapter(String url) {
        return chapterMapper.findNewChapter(url);
    }

    @Override
    @LogTime
    public Chapter findChapterByUrl(String url) {
        Chapter chapter = new Chapter();
        chapter.setUrl(url);
        return super.selectOne(chapter);
    }
}
