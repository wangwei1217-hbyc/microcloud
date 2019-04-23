package cn.mldn.microcloud.controller;

import cn.mldn.vo.Dept;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangwei on 2019/4/7 0007.
 */
@RestController
public class ConsumerDeptController {
//    public static final String DEPT_GET_URL = "http://dept-8001.com:8001/dept/get/";
//    public static final String DEPT_LIST_URL = "http://dept-8001.com:8001/dept/list/";
//    public static final String DEPT_ADD_URL = "http://dept-8001.com:8001/dept/add";
    //MICROCLOUD-PROVIDER-DEPT
    public static final String DEPT_GET_URL = "http://MICROCLOUD-PROVIDER-DEPT/dept/get/";
    public static final String DEPT_LIST_URL = "http://MICROCLOUD-PROVIDER-DEPT/dept/list/";
    public static final String DEPT_ADD_URL = "http://MICROCLOUD-PROVIDER-DEPT/dept/add";

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private HttpHeaders headers;
    @Resource
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/consumer/dept/get/{id}",method = {RequestMethod.GET})
    public Object getDept(@PathVariable("id") long id){
//        Dept dept = restTemplate.getForObject(DEPT_GET_URL + id, Dept.class);
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("MICROCLOUD-PROVIDER-DEPT");
        System.out.println("【*** ServiceInstance ***】host = "+serviceInstance.getHost()+
                "、port = "+serviceInstance.getPort()+
                "、serviceId = "+serviceInstance.getServiceId());
        /**服务端加入安全策略后，客户端请求方式**/
        Dept dept = restTemplate.exchange(DEPT_GET_URL + id, HttpMethod.GET,
                new HttpEntity<Object>(headers), Dept.class).getBody();
        return dept;
    }

    @RequestMapping(value = "/consumer/dept/list",method = {RequestMethod.GET})
    public Object getDeptList(){
//        List deptList = restTemplate.getForObject(DEPT_LIST_URL, List.class);
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("MICROCLOUD-PROVIDER-DEPT");
        System.out.println("【*** ServiceInstance ***】host = "+serviceInstance.getHost()+
                "、port = "+serviceInstance.getPort()+
                "、serviceId = "+serviceInstance.getServiceId());
        /**服务端加入安全策略后，客户端请求方式*/
        List deptList = restTemplate.exchange(DEPT_LIST_URL, HttpMethod.GET,
                new HttpEntity<Object>(headers), List.class).getBody();
        return deptList;
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object addDept(Dept dept){
//        Boolean flag = restTemplate.postForObject(DEPT_ADD_URL, dept, Boolean.class);
        /**服务端加入安全策略后，客户端请求方式*/
        Boolean flag = restTemplate.exchange(DEPT_ADD_URL, HttpMethod.POST,
                new HttpEntity<Object>(dept, headers), Boolean.class).getBody();
        return flag;
    }
}
