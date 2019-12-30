package cn.mldn.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * http请求地址和资源文件映射如下:
 * -label:分支
 * -application：git上文件的名称
 * -profile: 对应spring.profiles配置项

 /{application}/{profile}[/{label}]
 /{application}-{profile}.yml
 /{label}/{application}-{profile}.yml
 /{application}-{profile}.properties
 /{label}/{application}-{profile}.properties

 --SpringCloudBus服务总线：
 1、依赖RabbitMq的发布/订阅模式完成微服务对变更配置文件的自动抓取。
    (SpringCloudBus服务启动后，RabbitMq里面会有一个springCloudBus的topic类型的Exchange)
 2、远端GitHub上的配置文件变更以后，需要以POST的方式手动请求SpringCloudBus服务上所暴露的的
    /bus/refresh地址，之后客户端服务就可以获取到最新的配置信息了：
    即curl -X POST http://root:root@config-server-bus-7201.com:7201/bus/refresh
    注意：权限校验时需添加：ACTUATOR角色，否则请求会报错：访问被拒绝
 public void configGlobal(AuthenticationManagerBuilder auth)throws Exception {
     auth.inMemoryAuthentication().withUser("root").password("root")
     .roles("admin","ACTUATOR").and().withUser("hu").password("hu")
     .roles("admin", "user","ACTUATOR");
 }
 3、如果想获取配置文件信息变更服务追踪信息的话，可以访问SpringCloudBus服务上的“/trace”地址，获取相关信息。
  3.1条件：
     -加入依赖：
 <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-actuator</artifactId>
 </dependency>
     -SpringCloudBus服务的application.yml上添加如下配置:
        spring.cloud.bus.trace.enabled=true

 */
@SpringBootApplication
@EnableConfigServer  //配置中心服务端注解
@EnableEurekaClient
public class ConfigServerBus_7201_StartSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerBus_7201_StartSpringApplication.class,args);
    }
}
