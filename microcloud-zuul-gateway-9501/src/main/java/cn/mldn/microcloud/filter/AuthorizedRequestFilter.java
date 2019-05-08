package cn.mldn.microcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * Created on 2019/5/8.
 */
public class AuthorizedRequestFilter extends ZuulFilter{
    @Override
    public String filterType() {
        // 在进行Zuul过滤的时候可以设置其他过滤执行的位置，那么此时有如下几种类型
        // pre:请求前设置
        // route 请求的时候
        // post :发送的
        // error: 出错之后
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;  // 设置优先级，数值越大优先级越高
    }

    @Override
    public boolean shouldFilter() {
        return true; // 该filter是否要执行
    }

    @Override
    public Object run() {
        // 表示具体的过滤执行操作
        RequestContext currentContext = RequestContext.getCurrentContext(); //获取当前请求的上下文
        String auth = "root:root"; //认证的原始信息
        byte[] encode = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII"))); //进行加密处理
//        在进行授权的头信息内容配置的时候加密的信息一定要与“Basic”之间有一个空格
        String authReader = "Basic " + new String(encode);
        currentContext.addZuulRequestHeader("Authorization",authReader);
        return null;
    }
}
