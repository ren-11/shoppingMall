package com.xzy.services.impl;

import com.xzy.dao.HomePageMapper;
import com.xzy.model.GoodsTable;
import com.xzy.services.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomePageServiceImpl implements HomePageService {
    @Autowired
    private HomePageMapper HP;

    @Override
    public List<GoodsTable> hotSale() {
        return HP.hotSale();
    }
}
