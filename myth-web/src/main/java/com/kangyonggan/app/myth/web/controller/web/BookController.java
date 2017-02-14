package com.kangyonggan.app.myth.web.controller.web;

import com.github.pagehelper.PageInfo;
import com.kangyonggan.app.myth.biz.service.BookService;
import com.kangyonggan.app.myth.biz.service.ChapterService;
import com.kangyonggan.app.myth.biz.service.DictionaryService;
import com.kangyonggan.app.myth.model.constants.DictionaryType;
import com.kangyonggan.app.myth.model.vo.Book;
import com.kangyonggan.app.myth.model.vo.Chapter;
import com.kangyonggan.app.myth.model.vo.Dictionary;
import com.kangyonggan.app.myth.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author kangyonggan
 * @since 2017/2/10
 */
@Controller
@RequestMapping("book")
public class BookController extends BaseController {

    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private BookService bookService;

    @Autowired
    private ChapterService chapterService;

    /**
     * 书籍首页
     *
     * @param model
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        // 导航栏
        List<Dictionary> categories = dictionaryService.findDictionariesByType(DictionaryType.BOOK.getType());

        // 最新4本书籍 order by id desc
        List<Book> new4books = bookService.findNewBooksByCategory(null, 4);

        // 最老9本书籍 order by id asc
        List<Book> old9books = bookService.findOldBooksByCategory(null, 9);

        // 玄幻小说13本
        List<Book> xuanhuan13books = bookService.findNewBooksByCategory("xuanhuan", 13);

        // 修真小说13本
        List<Book> xiuzhen13books = bookService.findNewBooksByCategory("xiuzhen", 13);

        // 都市小说13本
        List<Book> dushi13books = bookService.findNewBooksByCategory("dushi", 13);

        // 历史小说13本
        List<Book> lishi13books = bookService.findNewBooksByCategory("lishi", 13);

        // 网游小说13本
        List<Book> wangyou13books = bookService.findNewBooksByCategory("wangyou", 13);

        // 科幻小说13本
        List<Book> kehuan13books = bookService.findNewBooksByCategory("kehuan", 13);

        // 最近更新小说列表30本 order by updatedTime desc
        List<Book> active30books = bookService.findActiveBooksByCategory(null, 30);

        // 最新入库小说30本 order by id desc
        List<Book> new30books = bookService.findNewBooksByCategory(null, 30);

        model.addAttribute("categories", categories);
        model.addAttribute("new4books", new4books);
        model.addAttribute("old9books", old9books);
        model.addAttribute("xuanhuan13books", xuanhuan13books);
        model.addAttribute("xiuzhen13books", xiuzhen13books);
        model.addAttribute("dushi13books", dushi13books);
        model.addAttribute("lishi13books", lishi13books);
        model.addAttribute("wangyou13books", wangyou13books);
        model.addAttribute("kehuan13books", kehuan13books);
        model.addAttribute("active30books", active30books);
        model.addAttribute("new30books", new30books);
        return getPathIndex();
    }

    /**
     * 书籍栏目
     *
     * @param categoryCode
     * @param model
     * @return
     */
    @RequestMapping(value = "category/{categoryCode:[\\w]+}", method = RequestMethod.GET)
    public String category(@PathVariable("categoryCode") String categoryCode, Model model) {
        // 导航栏
        List<Dictionary> categories = dictionaryService.findDictionariesByType(DictionaryType.BOOK.getType());

        Dictionary category = dictionaryService.findDictionaryByCodeAndType(categoryCode, DictionaryType.BOOK.getType());
        List<Book> new6books = bookService.findNewBooksByCategory(categoryCode, 6);
        List<Book> active30books = bookService.findActiveBooksByCategory(categoryCode, 30);
        List<Book> old30books = bookService.findOldBooksByCategory(categoryCode, 30);

        model.addAttribute("categories", categories);
        model.addAttribute("category", category);
        model.addAttribute("new6books", new6books);
        model.addAttribute("active30books", active30books);
        model.addAttribute("old30books", old30books);
        model.addAttribute("old30books", old30books);
        return getPathRoot() + "/category";
    }

    /**
     * 书籍详情
     *
     * @param url
     * @param model
     * @return
     */
    @RequestMapping(value = "{url:[\\d]+}", method = RequestMethod.GET)
    public String book(@PathVariable("url") String url, Model model) {
        // 导航栏
        List<Dictionary> categories = dictionaryService.findDictionariesByType(DictionaryType.BOOK.getType());
        Book book = bookService.findBookByUrl(url);
        List<Chapter> chapters = chapterService.findChaptersByBookUrl(url);

        model.addAttribute("book", book);
        model.addAttribute("chapters", chapters);
        model.addAttribute("categories", categories);
        return getPathRoot() + "/book";
    }

    /**
     * 章节详情
     *
     * @param bookUrl
     * @param url
     * @param model
     * @return
     */
    @RequestMapping(value = "{bookUrl:[\\d]+}/chapter/{url:[\\d]+}", method = RequestMethod.GET)
    public String chapter(@PathVariable("bookUrl") String bookUrl, @PathVariable("url") String url, Model model) {
        // 导航栏
        List<Dictionary> categories = dictionaryService.findDictionariesByType(DictionaryType.BOOK.getType());
        Book book = bookService.findBookByUrl(bookUrl);
        Chapter chapter = chapterService.findChapterByUrl(url);
        Chapter prevChapter = chapterService.findPrevChapter(chapter.getId(), bookUrl);
        Chapter nextChapter = chapterService.findNextChapter(chapter.getId(), bookUrl);

        model.addAttribute("book", book);
        model.addAttribute("chapter", chapter);
        model.addAttribute("prevChapter", prevChapter);
        model.addAttribute("nextChapter", nextChapter);
        model.addAttribute("categories", categories);
        return getPathRoot() + "/chapter";
    }

    /**
     * 搜索小说
     *
     * @param pageNum
     * @param key
     * @param model
     * @return
     */
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String search(@RequestParam(value = "p", required = false, defaultValue = "1") int pageNum,
                         @RequestParam(value = "key", required = false, defaultValue = "") String key,
                         Model model) {
        // 导航栏
        List<Dictionary> categories = dictionaryService.findDictionariesByType(DictionaryType.BOOK.getType());
        List<Book> books = bookService.searchBooks(key.trim(), pageNum);
        PageInfo<Book> page = new PageInfo(books);

        model.addAttribute("page", page);
        model.addAttribute("categories", categories);
        return getPathRoot() + "/search";
    }

}
