package cn.mldn.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**turbine不需要添加@EnableHystrixDashboard注解*/
@SpringBootApplication
@EnableTurbine
public class Turbine_9101_StartSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(Turbine_9101_StartSpringApplication.class,args);
    }
}
