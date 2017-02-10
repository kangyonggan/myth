package com.kangyonggan.app.myth.web.controller.web;

import com.kangyonggan.app.myth.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author kangyonggan
 * @since 2017/2/10
 */
@Controller
@RequestMapping("book")
public class BookController extends BaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return getPathIndex();
    }

}
