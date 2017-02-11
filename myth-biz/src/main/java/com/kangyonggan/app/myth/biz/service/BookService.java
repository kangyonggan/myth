package com.kangyonggan.app.myth.biz.service;

import com.kangyonggan.app.myth.model.vo.Book;

/**
 * @author kangyonggan
 * @since 2017/2/11
 */
public interface BookService {

    /**
     * 判断书籍是否存在
     *
     * @param url
     * @return
     */
    boolean existBook(String url);

    /**
     * 保存书籍
     *
     * @param book
     */
    void saveBook(Book book);
}
