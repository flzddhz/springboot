package com.example.springboot.uitl.intercept;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;



@Component
@WebFilter(filterName = "TimerFilter",urlPatterns = "/*")     //过滤器，是在最前面的    可以获得Http原始的请求和响应信息，但是拿不到响应方法的信息。
public class TimerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter过滤器1     " + getClass() + " init");
    }

    /**
     * 在这方法中进行拦截
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter过滤器2     " + getClass() + " doFilter");
        chain.doFilter(request, response);                                          ////控制是否继续往后执行   没有这个则不会往后执行
    }

    @Override
    public void destroy() {
        System.out.println("Filter过滤器3     " + getClass() + " destroy  请求已死亡！");
    }

}
