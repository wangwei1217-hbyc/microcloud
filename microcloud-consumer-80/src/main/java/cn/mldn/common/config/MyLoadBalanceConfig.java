package cn.mldn.common.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;

/**
 * Created by wangwei on 2019/4/23.
 */
public class MyLoadBalanceConfig {
    @Bean
    public IRule ribbonRule(){
//        return new RandomRule();
        return new WeightedResponseTimeRule();
    }
}
