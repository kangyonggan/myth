package com.kangyonggan.app.myth.model.rss;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kangyonggan
 * @since 2017/1/24
 */
@Data
public class Feed {
    String title;
    String link;
    String description;
    String language;
    String copyright;
    String pubDate;
    List<FeedMessage> feedMessages = new ArrayList();

}
