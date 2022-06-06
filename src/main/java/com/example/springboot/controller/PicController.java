package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pic")
public class PicController {

    @RequestMapping("/fjz")
    public String tofjz(){
        return "pic/fjz";
    }

    @RequestMapping("/test")
    public String totest(){
        return "pic/test";
    }

    @RequestMapping("/xhb")
    public String toxhb(){
        return "pic/xhb";
    }
}
