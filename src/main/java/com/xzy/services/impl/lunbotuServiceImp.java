package com.xzy.services.impl;

import com.xzy.dao.bigpicMapper;
import com.xzy.model.bigpic;
import com.xzy.services.lunbotuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class lunbotuServiceImp implements lunbotuService {
    @Resource
    private bigpicMapper bigpicdao;
    @Override
    public List<bigpic> getTU() {
        return bigpicdao.lunbotu();
    }
}
