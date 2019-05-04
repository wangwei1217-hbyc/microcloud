package cn.mldn.service;

import cn.mldn.vo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created on 2019/5/3 0003.
 */
@Component
public class IDeptClientServiceFallbackFactory implements FallbackFactory<IDeptClientService> {
    @Override
    public IDeptClientService create(Throwable throwable) {
        return new IDeptClientService() {
            @Override
            public Dept get(@PathVariable("id") long id) {
                Dept dept = new Dept();
                dept.setDeptno(88888L);
                dept.setDname("ERROR-Dept Provider Service down");
                dept.setLoc("服务降级-由客户端提供");
                return dept;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
