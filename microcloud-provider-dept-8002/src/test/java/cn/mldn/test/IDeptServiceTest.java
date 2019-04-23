package cn.mldn.test;

import cn.mldn.microcloud.Dept_8002_StartSpringApplication;
import cn.mldn.microcloud.service.IDeptService;
import cn.mldn.vo.Dept;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by wangwei on 2019/4/7 0007.
 */
@SpringBootTest(classes = {Dept_8002_StartSpringApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class IDeptServiceTest {
    @Resource
    private IDeptService deptService;

    @Test
    public void testGet() {
        System.out.println(this.deptService.get(1));
        Assert.assertNotNull(this.deptService.get(1));
    }

    @Test
    public void testAdd() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Dept dept = new Dept() ;
        dept.setDname("测试部-" + df.format(new Date()));
        boolean result = this.deptService.add(dept);
        System.out.println(result);
        Assert.assertTrue(result);
    }

    @Test
    public void testList() {
        List<Dept> list =this.deptService.list();
        System.out.println(list);
        Assert.assertTrue("SUCCESS",list.size() > 0);
    }
}
