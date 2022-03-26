package com.example.springboot.uitl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 自动打开浏览器  （用于开发）
 */
@ConfigurationProperties("index-html")
@Component
public class OperBrowser implements CommandLineRunner {

    @Value("${index-html}")
    String index;

    @Override
    public void run(String... args){
        System.out.println("启动项目打开指定的页面！");
        try {
            Runtime.getRuntime().exec(index);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
