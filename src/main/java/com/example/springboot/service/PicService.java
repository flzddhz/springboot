package com.example.springboot.service;

import com.example.springboot.entity.Pic;

import java.util.List;

public interface PicService {
    void insertPic(Pic pic);

    List<Pic> selectPicList(String flag);
}
