package com.example.springboot.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootConfiguration
//@Component                  //用于普通类 配置Bean
public class SpringBootConfig{

//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        super.addInterceptors(registry);
//        registry.addInterceptor(new ApiInterceptor());
//    }


    @Bean("testBean")
    public TestConfig testBean(){
        return new TestConfig();
    }

//    @Bean("testBean")                 如果Bean的名字相同会  注入的是后面的定义的值
    @Bean
    public String  testBean1(){
        return "zxcvbnm";
    }
}
