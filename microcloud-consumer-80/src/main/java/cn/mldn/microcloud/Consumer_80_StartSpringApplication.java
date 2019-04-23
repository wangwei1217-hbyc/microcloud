package cn.mldn.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by wangwei on 2019/4/7 0007.
 */
@SpringBootApplication
@EnableEurekaClient
public class Consumer_80_StartSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_80_StartSpringApplication.class,args);
    }
}
