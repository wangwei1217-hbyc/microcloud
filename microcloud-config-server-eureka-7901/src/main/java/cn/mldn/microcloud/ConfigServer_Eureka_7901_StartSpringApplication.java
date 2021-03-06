package cn.mldn.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created  on 2019/4/20 0020.
 */
@SpringBootApplication
@EnableEurekaServer
public class ConfigServer_Eureka_7901_StartSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer_Eureka_7901_StartSpringApplication.class);
    }
}
