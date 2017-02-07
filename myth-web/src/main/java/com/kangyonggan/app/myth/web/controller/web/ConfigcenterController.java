package com.kangyonggan.app.myth.web.controller.web;

import com.alibaba.fastjson.JSONArray;
import com.kangyonggan.app.myth.biz.core.MyPropertyPlaceholderConfigurer;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URLDecoder;

/**
 * @author kangyonggan
 * @since 2017/1/27
 */
@Controller
@RequestMapping("configcenter")
@Log4j2
public class ConfigcenterController {

    /**
     * 接收配置中心推送过来的配置
     *
     * @param data
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public boolean receiver(@RequestParam("data") String data) {
        try {
            data = URLDecoder.decode(data, "UTF-8");
            MyPropertyPlaceholderConfigurer.load(JSONArray.parseArray(data));
        } catch (Exception e) {
            log.error("接收配置失败", e);
            return false;
        }
        return true;
    }

}
