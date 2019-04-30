package cn.mldn.common.config;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by on 2019/4/29.
 */
@Configuration
public class FeignClientConfig {
    /**开启feign的日志追踪(默认是不开启的)***/
    @Bean
    public Logger.Level getFeignLoggerLevel(){
        return Logger.Level.FULL;
    }
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("root","root");
    }
}
