package cn.mldn.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * SpringCloudConfig客户端：
 * -bootstrap.yml的优先级高于本地的application.yml。
 *  当二者中有相同的配置项时，以bootstrap.yml为准
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker //开启断路器
//@EnableDiscoveryClient
public class ConfigClient_7701_StartSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient_7701_StartSpringApplication.class,args);

    }
}
