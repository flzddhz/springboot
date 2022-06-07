package com.example.springboot.dao;

import com.example.springboot.entity.Pic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PicMapper {

    void insertPic(Pic pic);

    List<Pic> selectPicList(String flag);
}
