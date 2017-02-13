package com.kangyonggan.app.myth.model.vo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "chapter")
public class Chapter implements Serializable {
    /**
     * 主键, 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 章节名称
     */
    private String title;

    /**
     * 章节地址
     */
    private String url;

    /**
     * 书籍地址
     */
    @Column(name = "book_url")
    private String bookUrl;

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

    /**
     * 章节内容
     */
    private String content;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", bookUrl='" + bookUrl + '\'' +
                ", isDeleted=" + isDeleted +
                ", createdTime=" + createdTime +
                ", updatedTime=" + updatedTime +
                '}';
    }
}