package cn.mldn.microcloud.rest;

import cn.mldn.vo.Company;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;


/**
 * 熔断机制：
 *  hystrix.stream监控依赖注解： @HystrixCommand，只有添加了该注解，才能对对应的请求进行监控
 */
@RestController
public class ConfigClientRest {

    @RequestMapping(value = "/company/get/{title}",method = {RequestMethod.GET})
    @HystrixCommand
    public Object get(@PathVariable("title") String title){
        Company company = new Company();
        company.setTitle(title);
        company.setNote("www.xxxx.com");
        return company;

    }
}
