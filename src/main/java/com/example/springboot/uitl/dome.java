package com.example.springboot.uitl;

import com.example.springboot.entity.Pic;

import java.io.File;
import java.io.IOException;

public class dome {

    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Administrator\\Desktop\\tset1";
        dome dome1 = new dome();
        dome1.insertpic(path);
    }

    public void insertpic(String path) throws IOException {
        File file = new File(path);
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
//        System.out.println(file.getParent().substring(file.getParent().lastIndexOf("\\")+1,file.getParent().length()));
//        if (file.isDirectory()){
//            if (file.isFile()){
//                Pic pic = new Pic();
//                pic.setWjj(file.getParent().substring(file.getParent().lastIndexOf("\\"),file.getParent().length()));
//                pic.setFilename(file.getName());
//                pic.setJdpath(file.getPath());
//            }else{
//                File[] files = file.listFiles();
//                for (File f:files){
//                    if (file.isDirectory()){
//                        if (file.isFile()){
//
//                        }else{
//                            insertpic(f.getPath());
//                        }
//                    }
//                }
//            }
//
//        }
    }
}
