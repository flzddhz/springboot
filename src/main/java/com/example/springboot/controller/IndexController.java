package com.example.springboot.controller;

import com.example.springboot.entity.Test;
import com.example.springboot.service.TestService;
import com.example.springboot.service.TestService2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/main")
public class IndexController {

    @Resource
    private TestService testService;
    @Resource
    private TestService2 testService2;

    @RequestMapping("index")
    public String index() {
        List<Test> tests = testService.selectTest();
        System.out.println(tests.size());
        return "index";
    }

    @RequestMapping("tosql")
    public String tosql() {
        return "target/sql/sqllogin";
    }

    @RequestMapping("sqllogin")             //使用PostMapper可以避免表单注入
    public String sqllogin(Test test, HttpServletRequest request) {
        Test login = testService2.login(test.getLoginname(), test.getPwd());
        if(login != null){
            request.setAttribute("tips","登录成功！欢迎你：" + login.getLoginname());
        }else{
            request.setAttribute("tips","登录失败！");
        }
        return "target/sql/sqlindex";
    }

    @RequestMapping("toxss")
    public String toxss() {
        return "target/xss/xss";
    }

    @RequestMapping("tocsrf")
    public String tocsrf() {
        return "target/csrf/csrf";
    }

    @ExceptionHandler
    public String doError(Exception e,HttpServletRequest request) throws Exception {
        e.printStackTrace();
        request.setAttribute("error",e.getMessage());
        return "error";
    }

}
