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
@EnableCircuitBreaker
public class Upload_8201_StartSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(Upload_8201_StartSpringApplication.class,args);

    }
}
