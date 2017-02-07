package com.kangyonggan.app.myth.model.dto.request;

import com.kangyonggan.app.myth.model.BaseObject;
import com.kangyonggan.app.myth.model.annotation.Valid;
import lombok.Data;

/**
 * @author kangyonggan
 * @since 2017/1/18
 */
@Data
public class DemoRequest extends BaseObject {

    @Valid(minLength = 5, maxLength = 32)
    private String name;

    @Valid(min = 0, max = 99)
    private int value;

}
