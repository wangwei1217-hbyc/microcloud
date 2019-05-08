package cn.mldn.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created on 2019/4/7 0007.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //开启断路器
//@EnableDiscoveryClient
public class Company_8101_StartSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(Company_8101_StartSpringApplication.class,args);

    }
}
