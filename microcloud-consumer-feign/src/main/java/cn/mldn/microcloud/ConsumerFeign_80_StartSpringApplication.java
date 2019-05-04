package cn.mldn.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by wangwei on 2019/4/7 0007.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"cn.mldn.service"})
@ComponentScan(basePackages = {"cn.mldn"})
public class ConsumerFeign_80_StartSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerFeign_80_StartSpringApplication.class,args);
    }
}
