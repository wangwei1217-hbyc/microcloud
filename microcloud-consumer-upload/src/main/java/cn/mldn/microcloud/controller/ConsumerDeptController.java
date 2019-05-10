package cn.mldn.microcloud.controller;

import cn.mldn.service.IDeptClientService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by wangwei on 2019/4/7 0007.
 */
@RestController
public class ConsumerDeptController {
//    public static final String DEPT_GET_URL = "http://dept-8001.com:8001/dept/get/";
//    public static final String DEPT_LIST_URL = "http://dept-8001.com:8001/dept/list/";
//    public static final String DEPT_ADD_URL = "http://dept-8001.com:8001/dept/add";
    @Resource
    private IDeptClientService deptClientService;

    @RequestMapping(value = "/consumer/dept/list",method = {RequestMethod.GET})
    public Object getDeptList(){
        return deptClientService.list();
    }
    @RequestMapping(value = "/consumer/dept/get/{id}",method = {RequestMethod.GET})
    public Object get(@PathVariable("id") long id){
        return deptClientService.get(id);
    }

}
