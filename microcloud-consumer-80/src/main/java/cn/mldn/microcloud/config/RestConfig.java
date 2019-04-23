package cn.mldn.microcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * Created by wangwei on 2019/4/7 0007.
 */
@Configuration
public class RestConfig {
    /** 要进行一个Http头信息配置*/
    @Bean
    public HttpHeaders getHttpHeaders(){
        // 定义一个HTTP的头信息
        HttpHeaders httpHeaders = new HttpHeaders();
        // 认证的原始信息
        String auth = "root:root";
        // 进行一个加密的处理
        byte[] encodeAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
        // 在进行授权的头信息内容配置的时候加密的信息一定要与“Basic”之间有一个空格
        String authHeader = "Basic " + new String(encodeAuth);
        httpHeaders.set("Authorization",authHeader);
        return httpHeaders;
    }
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
