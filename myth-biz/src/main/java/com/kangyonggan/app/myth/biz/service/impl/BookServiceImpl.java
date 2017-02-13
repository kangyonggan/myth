package com.kangyonggan.app.myth.biz.service.impl;

import com.github.pagehelper.PageHelper;
import com.kangyonggan.app.myth.biz.service.BookService;
import com.kangyonggan.app.myth.biz.util.Collections3;
import com.kangyonggan.app.myth.biz.util.StringUtil;
import com.kangyonggan.app.myth.mapper.BookMapper;
import com.kangyonggan.app.myth.model.annotation.LogTime;
import com.kangyonggan.app.myth.model.constants.AppConstants;
import com.kangyonggan.app.myth.model.vo.Book;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author kangyonggan
 * @since 2017/2/11
 */
@Service
public class BookServiceImpl extends BaseService<Book> implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    @LogTime
    public boolean existBook(String url) {
        Book book = new Book();
        book.setUrl(url);

        return bookMapper.selectCount(book) == 1;
    }

    @Override
    @LogTime
    public void saveBook(Book book) {
        super.insertSelective(book);
    }

    @Override
    @LogTime
    public List<Book> findNewBooksByCategory(String categoryCode, int limit) {
        Example example = new Example(Book.class);
        Example.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotEmpty(categoryCode)) {
            criteria.andEqualTo("categoryCode", categoryCode);
        }
        criteria.andEqualTo("isDeleted", AppConstants.IS_DELETED_NO);

        example.setOrderByClause("id desc");

        PageHelper.startPage(1, limit);
        return super.selectByExample(example);
    }

    @Override
    @LogTime
    public List<Book> findOldBooksByCategory(String categoryCode, int limit) {
        Example example = new Example(Book.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(categoryCode)) {
            criteria.andEqualTo("categoryCode", categoryCode);
        }
        criteria.andEqualTo("isDeleted", AppConstants.IS_DELETED_NO);

        PageHelper.startPage(1, limit);
        return super.selectByExample(example);
    }

    @Override
    @LogTime
    public List<Book> findActiveBooksByCategory(String categoryCode, int limit) {
        Example example = new Example(Book.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(categoryCode)) {
            criteria.andEqualTo("categoryCode", categoryCode);
        }
        criteria.andEqualTo("isDeleted", AppConstants.IS_DELETED_NO);

        example.setOrderByClause("updated_time desc");

        PageHelper.startPage(1, limit);
        return super.selectByExample(example);
    }

    @Override
    @LogTime
    public List<Book> updateBooks4engine(String categoryCode, String bookUrl, int pageNum) {
        Example example = new Example(Book.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(categoryCode)) {
            criteria.andEqualTo("categoryCode", categoryCode);
        }
        if (StringUtils.isNotEmpty(bookUrl)) {
            criteria.andEqualTo("bookUrl", bookUrl);
        }
        criteria.andEqualTo("isFinished", 0);
        criteria.andEqualTo("isLocked", 0);
        criteria.andEqualTo("isDeleted", 0);

        PageHelper.startPage(pageNum, AppConstants.PAGE_SIZE);
        List<Book> books = super.selectByExample(example);

        if (books.isEmpty()) {
            return books;
        }

        Book book = new Book();
        book.setIsLocked((byte) 1);

        Example example2 = new Example(Book.class);
        example2.createCriteria().andIn("id", Collections3.extractToList(books, "id"));

        bookMapper.updateByConditionSelective(book, example2);
        return books;
    }

    @Override
    @LogTime
    public void updateBook(Book book) {
        super.updateByPrimaryKeySelective(book);
    }

    @Override
    @LogTime
    public Book findBookByUrl(String url) {
        Book book = new Book();
        book.setUrl(url);
        book.setIsDeleted(AppConstants.IS_DELETED_NO);

        return super.selectOne(book);
    }

    @Override
    @LogTime
    public List<Book> searchBooks(String key, int pageNum) {
        Example example = new Example(Book.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(key)) {
            criteria.andLike("name", StringUtil.toLikeString(key));
            Example.Criteria criteria2 = example.createCriteria();
            criteria2.andLike("author", StringUtil.toLikeString(key));
            example.or(criteria2);
        }
        example.setOrderByClause("id desc");

        PageHelper.startPage(pageNum, 20);
        return super.selectByExample(example);
    }

    @Override
    @LogTime
    public void updateBooks4unlock(List<Book> books) {
        if (books.isEmpty()) {
            return;
        }
        Book book = new Book();
        book.setIsLocked((byte) 0);

        Example example = new Example(Book.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("id", Collections3.extractToList(books, "id"));

        bookMapper.updateByConditionSelective(book, example);
    }
}
