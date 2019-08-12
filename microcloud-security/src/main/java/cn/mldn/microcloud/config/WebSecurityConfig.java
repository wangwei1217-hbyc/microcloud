package cn.mldn.microcloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.annotation.Resource;

/**
 * Created by wangwei on 2019/4/7 0007.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**方案一：设置认证用户名和认证密码*/
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("root").password("root")
//                .roles("admin")
//                .and().withUser("hu").password("hu")
//                .roles("user");
//    }

    /**方案二：设置认证用户名和认证密码***/
    @Resource
    public void configGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication().withUser("root").password("root")
                .roles("admin","ACTUATOR").and().withUser("hu").password("hu")
                .roles("admin", "user","ACTUATOR");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表示所有的访问都必须进行认证处理后才可以正常进行访问
        /**.and().csrf().disable():针对跨域伪造不进行校验拦截**/
        http.httpBasic().and().authorizeRequests().anyRequest()
                .fullyAuthenticated().and().csrf().disable();
        //所有的Rest服务一定要设置为无状态，以提升操作性能
        //ALWAYS-保留session状态；STATELESS-session无状态
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/hystrix.stream","/turbine.stream");
    }
}
