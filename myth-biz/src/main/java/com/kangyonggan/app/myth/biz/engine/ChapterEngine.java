package com.kangyonggan.app.myth.biz.engine;

import com.kangyonggan.app.myth.biz.service.BookService;
import com.kangyonggan.app.myth.biz.service.ChapterService;
import com.kangyonggan.app.myth.biz.util.HtmlUtil;
import com.kangyonggan.app.myth.biz.util.PropertiesUtil;
import com.kangyonggan.app.myth.model.annotation.LogTime;
import com.kangyonggan.app.myth.model.vo.Book;
import com.kangyonggan.app.myth.model.vo.Chapter;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 章节引擎，用于抓取新章节
 *
 * @author kangyonggan
 * @since 2017/2/11
 */
@Log4j2
@Component
public class ChapterEngine {

    /**
     * 书籍根路径
     */
    private static String BOOK_BASE_URL = PropertiesUtil.getProperties("book.base.url");

    @Autowired
    private BookService bookService;

    @Autowired
    private ChapterService chapterService;

    /**
     * 执行
     *
     * @param categoryCode
     * @param bookUrl
     */
    @LogTime
    public void execute(String categoryCode, String bookUrl) {
        log.info("章节执行引擎开始工作");

        int pageNum = 1;
        List<Book> books;
        do {
            books = bookService.findBooks4engine(categoryCode, bookUrl, pageNum++);
            log.info("章节执行引擎此次查询到{}本书", books.size());

            for (Book book : books) {
                updateBook(book);
                log.info("{}的章节更新完毕", book.getName());
            }

        } while (!books.isEmpty());

        log.info("章节执行引擎结束工作");
    }

    /**
     * 更新书籍章节
     *
     * @param book
     */
    private void updateBook(Book book) {
        Document bookDoc = HtmlUtil.parseUrl(BOOK_BASE_URL + "book/" + book.getUrl());
        if (bookDoc == null) {
            return;
        }

        // 章节列表
        Elements chapters = bookDoc.select("#list dl dd a");

        int i = 0;// 最终指向最新章节的下下个章节
        String newChapterUrl = book.getNewChapterUrl();
        if (StringUtils.isNotEmpty(newChapterUrl)) {
            // 从上次更新的地方开始更新
            for (; i < chapters.size(); i++) {
                Element chapter = chapters.get(i);
                String chapterUrl = chapter.attr("href");
                chapterUrl = chapterUrl.substring(chapterUrl.lastIndexOf("/") + 1, chapterUrl.lastIndexOf("."));
                if (chapterUrl.equals(newChapterUrl)) {
                    break;
                }
            }

            i++;// 从下一章开始更新
            for (; i < chapters.size(); i++) {
                Element chapter = chapters.get(i);
                String chapterUrl = chapter.attr("href");
                chapterUrl = chapterUrl.substring(chapterUrl.lastIndexOf("/") + 1, chapterUrl.lastIndexOf("."));
                processChapter(chapterUrl, book);
            }
        } else {
            // 新书，从头更新
            // 先删除本书的所有章节
            chapterService.deleteChaptersByBookUrl(book.getUrl());
            for (; i < chapters.size(); i++) {
                Element chapter = chapters.get(i);
                String chapterUrl = chapter.attr("href");
                chapterUrl = chapterUrl.substring(chapterUrl.lastIndexOf("/") + 1, chapterUrl.lastIndexOf("."));
                processChapter(chapterUrl, book);
            }
        }

        // 把最新章节更新到书籍中
        Element chapter = chapters.get(i - 2);
        String chapterTitle = chapter.html();
        String chapterUrl = chapter.attr("href");
        chapterUrl = chapterUrl.substring(chapterUrl.lastIndexOf("/") + 1, chapterUrl.lastIndexOf("."));
        book.setNewChapterUrl(chapterUrl);
        book.setNewChapterTitle(chapterTitle);

        log.info("更新了书籍的最新章节", book);

        bookService.updateBook(book);
    }

    /**
     * 处理章节
     *
     * @param chapterUrl
     * @param book
     */
    private void processChapter(String chapterUrl, Book book) {
        Document chapterDoc = HtmlUtil.parseUrl(BOOK_BASE_URL + "book/" + book.getUrl() + "/" + chapterUrl + ".html");
        if (chapterDoc == null) {
            return;
        }

        String title = chapterDoc.select(".bookname h1").html().trim();
        String content = chapterDoc.getElementById("content").html();

        Chapter chapter = new Chapter();
        chapter.setTitle(title);
        chapter.setContent(content);
        chapter.setBookUrl(book.getUrl());

        log.info("更新了章节:{}", chapter);

        chapterService.saveChapter(chapter);
    }
}


