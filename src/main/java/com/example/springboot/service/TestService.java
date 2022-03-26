package com.example.springboot.service;

import com.example.springboot.entity.Test;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TestService {

    public Double testService(int num1,int num2);

    List<Test> selectTest();
}
