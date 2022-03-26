package com.example.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootConfiguration
//@EnableAutoConfiguration      @ SpringBootApplication  中包含这三个注解   在源码中可以看到
//@ComponentScanpublic
//@MapperScan("com.example.springboot.dao")             //和mapper接口上的  @Mapper  选一个即可
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

}
