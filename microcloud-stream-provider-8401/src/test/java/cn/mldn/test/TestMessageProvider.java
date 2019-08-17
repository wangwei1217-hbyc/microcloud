package cn.mldn.test;

import cn.mldn.microcloud.StreamProvider_8401_StartSpringApplication;
import cn.mldn.microcloud.service.IMessageProvider;
import cn.mldn.vo.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {StreamProvider_8401_StartSpringApplication.class})
@WebAppConfiguration
public class TestMessageProvider {
    @Resource
    private IMessageProvider provider;
    @Test
    public void testSend(){
        Company company = new Company();
        company.setTitle("RoutingKey消息通道测试");
        company.setNote("SpringCloudStream-RoutingKey消息通道");
        provider.send(company);
        System.out.println("-----over----");
    }
}
