package com.example.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "loginuser")          //使用该注解只能配合set注入使用     必须要声明注入类  @Component @Controller 等。
public class TestController {
    //    @Value("${loginuser.name}")
    private String name;
    //    @Value("${loginuser.pwd}")
    private String pwd;

    public void setName(String name){
        this.name = name;
    }
    public void setPwd(String pwd){
        this.pwd = pwd;
    }

//    public TestController(String name,String pwd){
//        this.name = name;
//        this.pwd = pwd;
//    }

    public String hquser() {
        return name + "---" + pwd;
    }
}
