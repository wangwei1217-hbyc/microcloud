package cn.mldn.service;

import cn.mldn.common.config.FeignClientConfig;
import cn.mldn.vo.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created on 2019/4/29.
 *
 */
//@FeignClient(value = "MICROCLOUD-PROVIDER-DEPT",configuration = FeignClientConfig.class,fallbackFactory = IDeptClientServiceFallbackFactory.class)
@FeignClient(value = "MICROCLOUD-ZUUL-GATEWAY",configuration = FeignClientConfig.class,fallbackFactory = IDeptClientServiceFallbackFactory.class)
public interface IDeptClientService {
    @RequestMapping(value = "/dept-proxy/dept/get/{id}",method = {RequestMethod.GET})
    Dept get(@PathVariable("id") long id);

    @RequestMapping(value = "/dept-proxy/dept/add",method = {RequestMethod.POST})
    boolean add(Dept dept);

    @RequestMapping(value = "/dept-proxy/dept/list",method = {RequestMethod.GET})
    List<Dept> list();
}
