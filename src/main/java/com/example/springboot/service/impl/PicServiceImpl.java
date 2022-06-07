package com.example.springboot.service.impl;

import com.example.springboot.dao.PicMapper;
import com.example.springboot.entity.Pic;
import com.example.springboot.service.PicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PicServiceImpl implements PicService {

    @Resource
    private PicMapper picMapper;
    @Override
    public void insertPic(Pic pic) {
        picMapper.insertPic(pic);
    }

    @Override
    public List<Pic> selectPicList(String flag) {
        return picMapper.selectPicList(flag);
    }
}
