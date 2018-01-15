package com.mc.family.config;

import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ChenglongChu
 * @description 通用过滤器
 * @create 2017/12/13 16:36
 * @since v0.1
 */
@Component
public class FilterCommon implements Filter {
    /**
     * @description 初始化
     * @param filterConfig 过滤器参数
     * @throws javax.servlet.ServletException
     * @author ChenglongChu
     * @create 2017/12/14 15:48
    **/
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * @description 过滤器执行过程
     * @param servletRequest servlet请求参数
     * @param servletResponse servlet返回参数
     * @param filterChain 过滤器链
     * @throws java.io.IOException
     * @throws javax.servlet.ServletException
     * @author ChenglongChu
     * @create 2017/12/14 15:49
    **/
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        // 解决response跨域问题
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
        response.setHeader("Access-Control-Allow-Methods", request.getHeader("Access-Control-Request-Method"));
        // 设置字符编码
        response.setContentType("text/html;charset=UTF-8");
        // ajax dynamic init
        response.setHeader("Cache-Control", "no-cache");

        // 转发请求
        filterChain.doFilter(request, response);
    }

    /**
     * @description 销毁
     * @author ChenglongChu
     * @create 2017/12/14 15:57
    **/
    @Override
    public void destroy() {

    }
}
