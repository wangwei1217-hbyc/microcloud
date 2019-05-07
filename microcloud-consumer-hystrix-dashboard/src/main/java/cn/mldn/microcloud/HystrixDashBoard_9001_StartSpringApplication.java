package cn.mldn.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoard_9001_StartSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoard_9001_StartSpringApplication.class,args);
    }
}
