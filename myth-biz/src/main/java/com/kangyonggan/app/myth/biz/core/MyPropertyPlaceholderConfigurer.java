package com.kangyonggan.app.myth.biz.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kangyonggan.app.myth.biz.util.HttpUtil;
import com.kangyonggan.app.myth.biz.util.PropertiesUtil;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @author kangyonggan
 * @since 2017/1/25
 */
@Log4j2
public class MyPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

    public MyPropertyPlaceholderConfigurer() {
        loadConfigs();
    }

    /**
     * 加载配置
     */
    private void loadConfigs() {
        String server = PropertiesUtil.getProperties("config.center.server");
        log.info("配置中心服务地址:{}", server);

        String data = HttpUtil.sendGet(server);

        if (StringUtils.isEmpty(data)) {
            throw new RuntimeException("读取配置中心异常");
        }

        log.info("已成功获取配置中心的配置");

        JSONObject jsonObject = JSON.parseObject(data);
        String errCode = (String) jsonObject.get("errCode");
        String errMsg = (String) jsonObject.get("errMsg");

        log.info("errCode:{}", errCode);
        log.info("errMsg:{}", errMsg);

        if (!"success".equals(errCode)) {
            throw new RuntimeException("读取配置中心失败");
        }

        JSONArray jsonArray = jsonObject.getJSONArray("configs");
        log.info("共有{}项配置!", jsonArray.size());

        load(jsonArray);
    }

    /**
     * 加载配置
     *
     * @param jsonArray
     */
    public static void load(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            log.info("正在存储配置:{}", object);

            String name = object.getString("name").trim();
            String value = object.getString("value").trim();

            System.setProperty(name, value);
            PropertiesUtil.putProperties(name, value);
        }

        log.info("从配置中心加载配置完毕！！！");
    }

}
