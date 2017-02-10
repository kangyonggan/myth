package com.kangyonggan.app.myth.model.rss;

import lombok.Data;

/**
 * @author kangyonggan
 * @since 2017/1/24
 */
@Data
public class FeedMessage {

    String title;

    String description;

    String link;

    String author;

    String guid;

    String pubDate;

}
