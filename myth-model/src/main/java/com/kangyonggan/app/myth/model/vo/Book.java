package com.kangyonggan.app.myth.model.vo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "book")
public class Book implements Serializable {
    /**
     * 主键, 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 书名
     */
    private String name;

    /**
     * 作者
     */
    private String author;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 首图
     */
    private String picture;

    /**
     * 地址
     */
    private String url;

    /**
     * 书籍栏目代码
     */
    @Column(name = "category_code")
    private String categoryCode;

    /**
     * 书籍栏目名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 最新章节URL
     */
    @Column(name = "new_chapter_url")
    private String newChapterUrl;

    /**
     * 最新章节名称
     */
    @Column(name = "new_chapter_title")
    private String newChapterTitle;

    /**
     * 是否完结:{0:未完结, 1:已完结}
     */
    @Column(name = "is_finished")
    private Byte isFinished;

    /**
     * 是否已锁:{0:未锁定, 1:已锁定}
     */
    @Column(name = "is_locked")
    private Byte isLocked;

    /**
     * 逻辑删除:{0:未删除, 1:已删除}
     */
    @Column(name = "is_deleted")
    private Byte isDeleted;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 更新时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;

    private static final long serialVersionUID = 1L;
}