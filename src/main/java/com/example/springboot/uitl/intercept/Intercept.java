package com.example.springboot.uitl.intercept;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Intercept implements HandlerInterceptor {              //Intercetor  拦截器  可以获得Http原始的请求和响应信息，也拿得到响应方法的信息，但是拿不到方法响应中的参数的值。
    //请求之前     控制器（controller）方法调用之前会进行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("HandlerInterceptor拦截器1     " + getClass() + " preHandle");
        return true;
//        return false;                         //控制是否继续往后执行
    }

    //请求时      控制后方法执行之后会进行，抛出异常则不会被执
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
//        Long start = (Long) request.getAttribute("startTime");
        System.out.println("HandlerInterceptor拦截器2     " + getClass() + " postHandle -- 输出表示请求正常执行完毕");//获取不到开始时间   请求执行所有时间 =    + (System.currentTimeMillis() - start));
    }

    //请求完成    方法被调用或者抛出异常都会被执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        System.out.println("HandlerInterceptor拦截器3     " + getClass() + " afterCompletion   finally");
    }
}
