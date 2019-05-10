package cn.mldn.microcloud.filter;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(LoginFilter.class);



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String contentType = servletRequest.getContentType();
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        if(!StringUtils.isEmpty(contentType) && contentType.contains("multipart/form-data")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            // 防止流读取一次后就没有了, 所以需要将流继续写出去
            ServletRequest requestWrapper =  new  CloneRequestWrapper((HttpServletRequest)servletRequest);
            //ServletResponse responseWrapper = new CloneResponseWrapper((HttpServletResponse)servletResponse);
            filterChain.doFilter(requestWrapper, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
