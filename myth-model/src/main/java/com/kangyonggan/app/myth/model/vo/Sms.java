package com.kangyonggan.app.myth.model.vo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "sms")
public class Sms implements Serializable {
    /**
     * 主键, 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 短信代码
     */
    private String code;

    /**
     * 接收号码
     */
    private String mobile;

    /**
     * 验证码
     */
    private String token;

    /**
     * 返回结果
     */
    private String result;

    /**
     * 错误码
     */
    @Column(name = "err_co")
    private String errCo;

    /**
     * 错误描述
     */
    @Column(name = "err_msg")
    private String errMsg;

    /**
     * 失效时间
     */
    @Column(name = "expire_time")
    private Date expireTime;

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