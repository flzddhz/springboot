package com.example.springboot.config;

import com.example.springboot.uitl.intercept.Intercept;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootConfiguration
public class WebConfin extends WebMvcConfigurerAdapter {  //继承WebMvcConfigurationSupport会将所有得默认配置都删除  包括 static 文件夹得配置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new Intercept());
    }
}
