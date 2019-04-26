package cn.mldn.microcloud;

import cn.mldn.common.config.MyLoadBalanceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * Created by wangwei on 2019/4/7 0007.
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "ribbonClient",configuration = MyLoadBalanceConfig.class)
public class Consumer_80_StartSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(Consumer_80_StartSpringApplication.class,args);
    }
}
