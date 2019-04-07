package cn.mldn.microcloud.controller;

import cn.mldn.vo.Dept;
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
    public static final String DEPT_GET_URL = "http://dept-8001.com:8001/dept/get/";
    public static final String DEPT_LIST_URL = "http://dept-8001.com:8001/dept/list/";
    public static final String DEPT_ADD_URL = "http://dept-8001.com:8001/dept/add/";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/get/{id}",method = {RequestMethod.GET})
    public Object getDept(@PathVariable("id") long id){
        Dept dept = restTemplate.getForObject(DEPT_GET_URL + id, Dept.class);
        return dept;
    }

    @RequestMapping(value = "/consumer/dept/list",method = {RequestMethod.GET})
    public Object getDeptList(){
        List deptList = restTemplate.getForObject(DEPT_LIST_URL, List.class);
        return deptList;
    }

    @RequestMapping(value = "/consumer/dept/add")
    public Object addDept(Dept dept){
        Boolean flag = restTemplate.postForObject(DEPT_ADD_URL, dept, Boolean.class);
        return flag;
    }
}
