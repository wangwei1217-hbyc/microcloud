package cn.mldn.microcloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by wangwei on 2019/8/12 0012.
 */
@Component
@RefreshScope
public class InfoConfig {
    @Value("${info.app.name}")
    private String appName;
    @Value("${info.app.version}")
    private String appVersion;

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

}
