package cn.mldn.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created on 2019/4/7 0007.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class StreamProvider_8401_StartSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(StreamProvider_8401_StartSpringApplication.class,args);

    }
}
