package com.example.springboot.controller;

import com.example.springboot.config.SpringBootConfig;
import com.example.springboot.config.TestConfig;
import com.example.springboot.entity.User;
import com.example.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.lang.reflect.Field;
import java.util.List;

@RestController
@ConfigurationProperties(prefix = "loginuser")           //使用该注解只能配合set注入使用     必须要声明注入类  @Component @Controller 等。
public class HelloController {

    /**
     * 以下使用的  @Resouce  都是属于依赖注入   也就是传说中的  Spring IOC  使用Spinrg容器创建的一些对象
     */
    @Resource
    private SpringBootConfig springBootConfig;
    @Resource
    private TestController testController;
    //    @Value("${loginuser.name}")
    private String name;
    //    @Value("${loginuser.pwd}")
    private String pwd;

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Resource(description = "testConfig")          //注入bean  相同名字可以省略
    private TestConfig testConfig;
    @Resource
    private String testConfig1;
    @Resource
    private TestService testService;

    //    @ResponseBody
    @GetMapping("hello")
    public String hello(HttpServletRequest request) {
//        System.out.println(springBootConfig.testBean().test());
//        System.out.println(testConfig.test());
//        System.out.println(testConfig1);
//        System.out.println(testController.hquser());
//        System.out.println(name + "---" + pwd);
//        try {             有全局的异常处理后可以省略掉  局部的
//        Double result = testService.testService(1, 1);
//            System.out.println(request.getAttribute("startTime"));
//        System.out.println("Controller result = " + result);
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
        User user = new User();
//        login(user);


        return "Hello World!!";
    }

//    @GetMapping("/testfr/hello")
//    public String hello2(){
//        System.out.println("测试Filter拦截器   @WebFilter属性");
//        return "Hello World!!";
//    }

    /**
     * 整个controller的一个异常处理   最佳用法 跳转到一个错误界面  用错误信息做一些提示来提醒使用者   并且插入一条错误日志
     * 据说是使用到了   Spring AOP 底层的原理还不太理解
     *
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler
    public String doError(Exception e) throws Exception {
        e.printStackTrace();
        return "Error 程序出错了！   请联系管理员";
    }

    @GetMapping("login")
    public String login(@Valid User user, BindingResult ret) {
        if (ret.hasFieldErrors()) {
            List<FieldError> errorList = ret.getFieldErrors();
            errorList.stream().forEach(item -> Assert.isTrue(false, item.getDefaultMessage()));
        }
        return "登录！！！";
    }

    protected void validate(BindingResult result) {
        if (result.hasFieldErrors()) {
            List<FieldError> errorList = result.getFieldErrors();
            errorList.stream().forEach(item -> Assert.isTrue(false, item.getDefaultMessage()));
        }
    }

//    @GetMapping("authorize")
//    public void authorize(@Valid AuthorizeIn authorize, BindingResult ret) {
//        if (result.hasFieldErrors()) {
//            List<FieldError> errorList = result.getFieldErrors();
//            //通过断言抛出参数不合法的异常
//            errorList.stream().forEach(item -> Assert.isTrue(false, item.getDefaultMessage()));
//        }
//    }
}

