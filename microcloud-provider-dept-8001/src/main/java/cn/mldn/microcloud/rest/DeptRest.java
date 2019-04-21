package cn.mldn.microcloud.rest;

import cn.mldn.microcloud.service.IDeptService;
import cn.mldn.vo.Dept;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by wangwei on 2019/4/7 0007.
 */
@RestController
public class DeptRest {
    @Resource
    private IDeptService deptService;

    @RequestMapping(value = "/dept/get/{id}",method = {RequestMethod.GET})
    public Object get(@PathVariable("id") long id){
        return deptService.get(id);
    }

    @RequestMapping(value = "/dept/add",method = {RequestMethod.POST})
    public Object add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/list",method = {RequestMethod.GET})
    public Object list(){
        return deptService.list();
    }

    @RequestMapping(value = "/dept/sessionId")
    public Object sessionId(HttpServletRequest request){
        return request.getSession().getId();
    }
}
