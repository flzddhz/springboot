package com.example.springboot.dao;

import com.example.springboot.entity.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

//@Component   想跳过@Mapper   @Component 只能使用在类的上面，
public interface TestMapper2 {
    public Test login(String username,String password);
}
