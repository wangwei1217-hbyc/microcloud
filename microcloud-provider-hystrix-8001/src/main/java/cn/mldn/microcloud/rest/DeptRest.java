package cn.mldn.microcloud.rest;

import cn.mldn.microcloud.service.IDeptService;
import cn.mldn.vo.Dept;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 熔断机制：
 *  hystrix.stream监控依赖注解： @HystrixCommand，只有添加了该注解，才能对对应的请求进行监控
 */
@RestController
public class DeptRest {
    @Resource
    private IDeptService deptService;

    @RequestMapping(value = "/dept/get/{id}",method = {RequestMethod.GET})
    @HystrixCommand(fallbackMethod = "getFallback") //如果当前调用的get接口出现错误抛出了异常，则会执行getFallback方法
    public Object get(@PathVariable("id") long id){
        Dept dept = deptService.get(id);
        if(dept == null){
            throw new RuntimeException("Id="+id+"的部门信息不存在");
        }
        return dept;
    }

    @RequestMapping(value = "/dept/add",method = {RequestMethod.POST})
    public Object add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/list",method = {RequestMethod.GET})
    @HystrixCommand
    public Object list(){
        return deptService.list();
    }

    @RequestMapping(value = "/dept/sessionId")
    public Object sessionId(HttpServletRequest request){
        return request.getSession().getId();
    }

    //方法的参数与get()方法一致
    public Object getFallback(@PathVariable("id") long id){
        //错误提示数据返回(具体的业务处理)
        Dept dept = new Dept();
        dept.setDeptno(99999L);
        dept.setDname("ERROR");
        dept.setLoc("DEPT-PROVIDER");
        return dept;
    }
}
