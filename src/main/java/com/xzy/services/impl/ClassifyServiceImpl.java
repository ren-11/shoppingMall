package com.xzy.services.impl;

import com.xzy.dao.CMapper;
import com.xzy.model.GoodsTable;
import com.xzy.services.ClassifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("classify")
public class ClassifyServiceImpl implements ClassifyService{

    @Resource
    private CMapper cf;

    @Override
    public List<GoodsTable> classifyleft(long fid) {
        return cf.classifyleft(fid);
    }

    @Override
    public List<GoodsTable> hotclassify() {
        return cf.hotclassify();
    }

    @Override
    public List<GoodsTable> recommendclassiify() {
        return cf.recommendclassify();
    }
}
