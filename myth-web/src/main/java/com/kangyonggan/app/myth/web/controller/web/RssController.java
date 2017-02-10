package com.kangyonggan.app.myth.web.controller.web;

import com.kangyonggan.app.myth.biz.service.ArticleService;
import com.kangyonggan.app.myth.biz.util.MarkdownUtil;
import com.kangyonggan.app.myth.biz.util.PropertiesUtil;
import com.kangyonggan.app.myth.biz.util.RSSFeedWriter;
import com.kangyonggan.app.myth.model.constants.AppConstants;
import com.kangyonggan.app.myth.model.rss.Feed;
import com.kangyonggan.app.myth.model.rss.FeedMessage;
import com.kangyonggan.app.myth.model.vo.Article;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author kangyonggan
 * @since 2017/1/24
 */
@RestController
@RequestMapping("/")
@Log4j2
public class RssController {

    private static final String BASE_URL = "http://kangyonggan.com/#article/";
    private static final String RSS_NAME = "blog.xml";

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private ArticleService articleService;

    /**
     * 刷新rss
     *
     * @return
     */
    @RequestMapping(value = "rss/refresh", method = RequestMethod.GET)
    public String refresh() {
        Feed feed = new Feed();
        feed.setDescription("记录生活、工作和学习时的笔记心得等");
        feed.setLink("http://kangyonggan.com");
        feed.setTitle("朕的博客");
        List<FeedMessage> feedMessages = feed.getFeedMessages();

        try {
            List<Article> articles = articleService.findAllArticles();
            for (int i = 0; i < articles.size(); i++) {
                Article article = articles.get(i);
                FeedMessage feedMessage = new FeedMessage();

                feedMessage.setTitle(article.getTitle());
                feedMessage.setLink(BASE_URL + article.getId());
                feedMessage.setDescription(MarkdownUtil.markdownToHtml(article.getContent()));
                Date date = article.getUpdatedTime();
                date.setTime(date.getTime() - 8 * 60 * 60 * 1000);
                feedMessage.setPubDate(format.format(date));
                feedMessages.add(feedMessage);
            }

            File file = new File(PropertiesUtil.getProperties(AppConstants.FILE_PATH_ROOT) + AppConstants.FILE_UPLOAD_PATH + RSS_NAME);

            if (!file.exists()) {
                file.createNewFile();
            }

            new RSSFeedWriter(feed, file.getPath()).write();

            log.info("rss刷新成功");
            return "success";
        } catch (Exception e) {
            log.error("查询所有文章失败", e);
        }

        return "failure";
    }

}
