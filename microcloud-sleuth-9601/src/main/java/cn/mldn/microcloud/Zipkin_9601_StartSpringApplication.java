package cn.mldn.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class Zipkin_9601_StartSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(Zipkin_9601_StartSpringApplication.class,args);
    }
}
