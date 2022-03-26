package com.example.springboot.dao;

import com.example.springboot.entity.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper         //与springboot启动类的@MapperScan  选一个即可
public interface TestMapper {

    List<Test> selectTest();


}
