package cn.mldn.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
//@EnableZipkinServer  //内存中
@EnableZipkinStreamServer //流的方式并持久化
public class Zipkin_9601_StartSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(Zipkin_9601_StartSpringApplication.class,args);
    }
}
