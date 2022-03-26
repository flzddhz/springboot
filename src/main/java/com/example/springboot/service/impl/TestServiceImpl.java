package com.example.springboot.service.impl;

import com.example.springboot.dao.TestMapper;
import com.example.springboot.entity.Test;
import com.example.springboot.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service                                                    //一定要写在实现层   必要时带上名字
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;

    @Override
    public Double testService(int num1, int num2) {
        return Double.valueOf(num1/num2);
    }

    @Override
    public List<Test> selectTest() {
        return testMapper.selectTest();
    }

}
