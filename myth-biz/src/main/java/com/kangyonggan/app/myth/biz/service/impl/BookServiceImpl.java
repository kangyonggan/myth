package com.kangyonggan.app.myth.biz.service.impl;

import com.kangyonggan.app.myth.biz.service.BookService;
import com.kangyonggan.app.myth.mapper.BookMapper;
import com.kangyonggan.app.myth.model.annotation.LogTime;
import com.kangyonggan.app.myth.model.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
