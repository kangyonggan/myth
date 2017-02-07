package com.kangyonggan.app.myth.model.dto.response;

import com.github.pagehelper.PageInfo;
import com.kangyonggan.app.myth.model.BaseObject;
import com.kangyonggan.app.myth.model.constants.ResponseState;
import lombok.Data;

import java.util.List;

/**
 * @author kangyonggan
 * @since 2016/12/25
 */
@Data
public class CommonResponse<T> extends BaseObject {

    private static final Long serialVersionUID = -1L;

    /**
     * 响应状态
     */
    private ResponseState state;

    /**
     * 响应码
     */
    private String respCode;

    /**
     * 响应信息
     */
    private String respMsg;

    /**
     * 单条数据
     */
    private T data;

    /**
     * 数据集合
     */
    private List<T> list;

    /**
     * 分页数据
     */
    private PageInfo<T> page;
}
