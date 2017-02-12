package com.kangyonggan.app.myth.biz.service;

import com.kangyonggan.app.myth.model.vo.Book;

import java.util.List;

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

    /**
     * 根据栏目查找最新书籍
     *
     * @param categoryCode
     * @param limit
     * @return
     */
    List<Book> findNewBooksByCategory(String categoryCode, int limit);

    /**
     * 根据栏目查找最老书籍
     *
     * @param categoryCode
     * @param limit
     * @return
     */
    List<Book> findOldBooksByCategory(String categoryCode, int limit);

    /**
     * 根据栏目查找最新更新书籍
     *
     * @param categoryCode
     * @param limit
     * @return
     */
    List<Book> findActiveBooksByCategory(String categoryCode, int limit);

    /**
     * 查找书籍4更新章节
     *
     * @param categoryCode
     * @param bookUrl
     * @param pageNum
     * @return
     */
    List<Book> findBooks4engine(String categoryCode, String bookUrl, int pageNum);

    /**
     * 更新书籍
     *
     * @param book
     */
    void updateBook(Book book);

    /**
     * 查找书籍
     *
     * @param url
     * @return
     */
    Book findBookByUrl(String url);

    /**
     * 搜索小说
     *
     * @param key
     * @param pageNum
     * @return
     */
    List<Book> searchBooks(String key, int pageNum);
}
