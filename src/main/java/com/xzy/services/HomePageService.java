package com.xzy.services;

import com.xzy.dao.HomePageMapper;
import com.xzy.model.GoodsTable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface HomePageService {
    List<GoodsTable> hotSale();//热销
}
