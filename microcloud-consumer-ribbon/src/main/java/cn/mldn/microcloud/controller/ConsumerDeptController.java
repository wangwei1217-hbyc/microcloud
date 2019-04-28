package cn.mldn.microcloud.controller;

import cn.mldn.common.config.MyLoadBalanceConfig;
import cn.mldn.vo.Dept;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * Created by wangwei on 2019/4/7 0007.
 */
@RestController
@RibbonClient(name = "microcloud-provider-dept",configuration = MyLoadBalanceConfig.class)
public class ConsumerDeptController {
//    public static final String DEPT_GET_URL = "http://dept-8001.com:8001/dept/get/";
//    public static final String DEPT_LIST_URL = "http://dept-8001.com:8001/dept/list/";
//    public static final String DEPT_ADD_URL = "http://dept-8001.com:8001/dept/add";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private HttpHeaders headers;
    @Resource
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/consumer/dept/list",method = {RequestMethod.GET})
    public Object getDeptList(){
        /**
         * 这个地方的服务名称跟application.yml中配置的服务名称相同：
         * --microcloud-provider-dept:
               ribbon:
                 listOfServers: http://dept-8001.com:8001,http://dept-8002.com:8002,http://dept-8003.com:8003
            脱离Eureka使用ribbon不依赖@LoadBalanced注解
         */
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microcloud-provider-dept");
        System.out.println("【*** ServiceInstance ***】host = "+serviceInstance.getHost()+
                "、port = "+serviceInstance.getPort()+
                "、serviceId = "+serviceInstance.getServiceId());
        /**服务端加入安全策略后，客户端请求方式*/
        URI uri = URI.create(String.format("http://%s:%s/dept/list/", serviceInstance.getHost(), serviceInstance.getPort()));
        List deptList = restTemplate.exchange(uri, HttpMethod.GET,
                new HttpEntity<Object>(headers), List.class).getBody();
        return deptList;
    }

}
