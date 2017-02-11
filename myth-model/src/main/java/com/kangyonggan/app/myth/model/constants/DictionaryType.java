package com.kangyonggan.app.myth.model.constants;

import lombok.Getter;

/**
 * 字典类型
 *
 * @author kangyonggan
 * @since 2016/12/3
 */
public enum DictionaryType {

    PROJECT("project", "项目"),
    TEMPLATE("template", "模板"),
    ATTACHMENT("attachment", "附件"),
    TAG("tag", "文章标签"),
    BOOK("book", "书籍类型");

    /**
     * 类型
     */
    @Getter
    private final String type;

    /**
     * 类型名称
     */
    @Getter
    private final String name;

    DictionaryType(String type, String name) {
        this.type = type;
        this.name = name;
    }

}
