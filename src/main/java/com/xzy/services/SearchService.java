package com.xzy.services;

import com.xzy.model.GoodsTable;
import com.xzy.vo.goods_tableVO;

import java.util.List;

public interface SearchService {
    List<GoodsTable> search(String key);
    List<goods_tableVO> search2(String key);
}
