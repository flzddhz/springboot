package com.example.springboot.service.impl;

import com.example.springboot.dao.Impl.TestMapper2Impl;
import com.example.springboot.dao.TestMapper2;
import com.example.springboot.entity.Test;
import com.example.springboot.service.TestService2;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestService2Impl implements TestService2 {

    @Resource
    private TestMapper2 testMapper2;        //未使用到@Mapper  获取不到，只要于根进程无关，不加载
    @Resource
    private TestMapper2Impl testMapper2i;  //使用的是@Component

    @Override
    public Test login(String username, String password) {
        return testMapper2i.login(username,password);
    }
}
