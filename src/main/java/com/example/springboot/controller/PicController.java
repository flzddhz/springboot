package com.example.springboot.controller;

import com.example.springboot.dao.PicMapper;
import com.example.springboot.entity.Pic;
import com.example.springboot.service.PicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/pic")
public class PicController {
//    String PATH = "C:\\Users\\Administrator\\Desktop\\tset1";
    String PATH = "/fh/img";

    @Resource
    private PicService picService;

    @RequestMapping("/fjz")
    public String tofjz(HttpServletRequest request) {
        List<Pic> list = picService.selectPicList("fjz");
        System.out.println("list.size() >>>>>=" + list.size());
        request.setAttribute("fjzlist",list);
        return "pic/fjz";
    }

    @RequestMapping("/test")
    public String totest() {
        return "pic/test";
    }

    @RequestMapping("/xhb")
    public String toxhb(HttpServletRequest request) {
        List<Pic> list = picService.selectPicList("xhb");
        System.out.println("list.size() >>>>>=" + list.size());
        request.setAttribute("xhblist",list);
        return "pic/xhb";
    }

    @RequestMapping("/insertpic")
    public void insertpic() {
        insertpic1(PATH);
    }

    public void insertpic1(String path) {
        File file = new File(path);
//        System.out.println(file.getPath());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                if (file.isDirectory()) {
                    insertpic1(f.getPath());
                } else {
                    Pic pic = new Pic();
                    pic.setWjj(file.getParent().substring(file.getParent().lastIndexOf("\\") + 1, file.getParent().length()));
                    pic.setFilename(file.getName());
                    pic.setJdpath(file.getPath());
                    picService.insertPic(pic);
                }
            }
        } else {
            Pic pic = new Pic();
            pic.setWjj(file.getParent().substring(file.getParent().lastIndexOf("\\") + 1, file.getParent().length()));
            pic.setFilename(file.getName());
            pic.setJdpath(file.getPath());
            picService.insertPic(pic);
        }
    }
}

