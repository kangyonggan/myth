package com.kangyonggan.app.myth.biz.engine;

import com.kangyonggan.app.myth.biz.service.BookService;
import com.kangyonggan.app.myth.biz.service.ChapterService;
import com.kangyonggan.app.myth.biz.service.DictionaryService;
import com.kangyonggan.app.myth.biz.util.HtmlUtil;
import com.kangyonggan.app.myth.biz.util.PropertiesUtil;
import com.kangyonggan.app.myth.model.annotation.LogTime;
import com.kangyonggan.app.myth.model.constants.DictionaryType;
import com.kangyonggan.app.myth.model.vo.Book;
import com.kangyonggan.app.myth.model.vo.Chapter;
import com.kangyonggan.app.myth.model.vo.Dictionary;
import lombok.extern.log4j.Log4j2;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 书籍引擎，用于抓取新书
 *
 * @author kangyonggan
 * @since 2017/2/11
 */
@Log4j2
@Component
public class BookEngine {

    /**
     * 书籍根路径
     */
    private static String BOOK_BASE_URL = PropertiesUtil.getProperties("book.base.url");

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private BookService bookService;

    @Autowired
    private ChapterService chapterService;

    /**
     * 书籍最新章节引擎
     */
    @LogTime
    public void updateBookNewChaper() {
        log.info("书籍最新章节引擎开始工作");

        int pageNum = 1;
        List<Book> books;
        do {
            books = bookService.updateBooks4engine(null, null, pageNum++);
            log.info("书籍最新章节引擎此次查询到{}本书", books.size());

            for (Book book : books) {
                Chapter chapter = chapterService.findNewChapter(book.getUrl());
                if (chapter == null) {
                    chapter = new Chapter();
                }
                book.setNewChapterUrl(chapter.getUrl());
                book.setNewChapterTitle(chapter.getTitle());

                bookService.updateBook(book);
            }

            bookService.updateBooks4unlock(books);
        } while (!books.isEmpty());

        log.info("书籍最新章节引擎结束工作");
    }

    /**
     * 执行
     */
    public void execute() {
        log.info("书籍执行引擎开始工作");

        List<Dictionary> categories = dictionaryService.findDictionariesByType(DictionaryType.BOOK.getType());
        for (Dictionary category : categories) {
            updateCategoryBooks(category);
        }

        log.info("书籍执行引擎结束工作");
    }

    /**
     * 更新某栏目的小说
     *
     * @param category
     */
    private void updateCategoryBooks(Dictionary category) {
        Document doc = HtmlUtil.parseUrl(BOOK_BASE_URL + category.getCode());

        if (doc == null) {
            return;
        }

        // 全本小说特殊处理
        if ("quanben".equals(category.getCode())) {
            Elements items = doc.select("#main .novelslist2 ul li");
            for (int i = 1; i < items.size(); i++) {
                processItem(category, items.get(i), ".s2 a");
            }
            return;
        }

        // hot栏的6本小说
        Elements items = doc.select("#hotcontent .ll .item");
        for (Element item : items) {
            processItem(category, item, "dl dt a");
        }

        // 左下列表
        items = doc.select("#newscontent .l ul li");
        for (Element item : items) {
            processItem(category, item, ".s2 a");
        }

        // 右下列表
        items = doc.select("#newscontent .r ul li");
        for (Element item : items) {
            processItem(category, item, ".s2 a");
        }

        log.info("{}已经更新完毕", category.getValue());
    }

    /**
     * 处理书籍
     *
     * @param category
     * @param item
     * @param selector
     */
    private void processItem(Dictionary category, Element item, String selector) {
        // 判断是否已经存在此书籍
        String url = item.select(selector).get(0).attr("href");
        url = url.substring(6).replaceAll("/", "");
        String bookName = item.select(selector).get(0).html().trim();

        if (bookService.existBook(url)) {
            log.info("{}已存在不需要更新", bookName);
            return;
        }

        updateBook(url, category);
    }

    /**
     * 更新书籍
     *
     * @param url
     * @param category
     */
    public void updateBook(String url, Dictionary category) {
        Document bookDoc = HtmlUtil.parseUrl(BOOK_BASE_URL + "book/" + url);

        if (bookDoc == null) {
            return;
        }

        // 封面图片
        String fmimg = bookDoc.select("#fmimg img").get(0).attr("src");
        // 书名
        String name = bookDoc.select("#info h1").get(0).html();
        // 作者
        String author = bookDoc.select("#info p").get(0).html();
        author = author.substring(author.indexOf("：") + 1).trim();
        // 简介
        String introduction = bookDoc.select("#intro p").get(0).html();
        // 最新章节
//        String newChapterTitle = bookDoc.select("#info p a").get(2).html();
//        String newChapterUrl = bookDoc.select("#info p a").get(2).attr("href");
//        newChapterUrl = newChapterUrl.substring(0, newChapterUrl.lastIndexOf("."));

        // 是否完结
        String status = bookDoc.select("#info p").get(1).html();
        byte isFinished = (byte) (status.indexOf("完结") > -1 ? 1 : 0);

        Book book = new Book();
        book.setAuthor(author);
        book.setName(name);
        book.setUrl(url);
        book.setCategoryCode(category.getCode());
        book.setCategoryName(category.getValue());
        book.setPicture(fmimg);
        book.setIntroduction(introduction);
//        book.setNewChapterUrl(newChapterUrl);
//        book.setNewChapterTitle(newChapterTitle);
        book.setIsFinished(isFinished);

        bookService.saveBook(book);
        log.info("新增书籍:{}", book);
    }
}


