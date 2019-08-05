package cn.mldn.microcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

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
 */
@SpringBootApplication
@EnableConfigServer  //配置中心服务端注解
public class ConfigServer_7101_StartSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServer_7101_StartSpringApplication.class,args);
    }
}
