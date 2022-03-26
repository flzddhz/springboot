package com.example.springboot.uitl;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class DoError {

    @ExceptionHandler
    public String doError(Exception e) throws Exception{
        e.printStackTrace();
        return e.getMessage();
    }
}
