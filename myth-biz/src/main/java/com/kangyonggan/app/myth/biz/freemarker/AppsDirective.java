package com.kangyonggan.app.myth.biz.freemarker;

import com.kangyonggan.app.myth.biz.shiro.SuperTag;
import com.kangyonggan.app.myth.biz.util.PropertiesUtil;
import freemarker.core.Environment;
import freemarker.template.ObjectWrapper;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author kangyonggan
 * @since 2016/12/2
 */
@Component
public class AppsDirective extends SuperTag {

    @Override
    public void render(Environment env, Map params, TemplateDirectiveBody body) throws IOException, TemplateException {
        env.setVariable("ftpUrl", ObjectWrapper.DEFAULT_WRAPPER.wrap(PropertiesUtil.getProperties("ftp.url")));
        env.setVariable("appName", ObjectWrapper.DEFAULT_WRAPPER.wrap(PropertiesUtil.getProperties("app.name")));
        env.setVariable("appAuthor", ObjectWrapper.DEFAULT_WRAPPER.wrap(PropertiesUtil.getProperties("app.author")));
        env.setVariable("appBaNo", ObjectWrapper.DEFAULT_WRAPPER.wrap(PropertiesUtil.getProperties("app.ba.no")));
        renderBody(env, body);
    }
}
