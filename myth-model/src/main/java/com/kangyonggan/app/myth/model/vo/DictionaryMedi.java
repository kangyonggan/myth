package com.kangyonggan.app.myth.model.vo;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Table(name = "dictionary_medi")
@Data
public class DictionaryMedi implements Serializable {
    /**
     * 主键, 自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 来源ID
     */
    @Column(name = "source_id")
    private Long sourceId;

    /**
     * 字典代码
     */
    @Column(name = "dictionary_code")
    private String dictionaryCode;

    /**
     * 类型
     */
    private String type;

    private static final long serialVersionUID = 1L;
}