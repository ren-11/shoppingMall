package com.xzy.dao;

import com.xzy.model.GoodsTable;
import com.xzy.vo.goods_tableVO;

import java.util.List;

public interface goods_tableMapper {

    List<GoodsTable> search1(String key);
    List<goods_tableVO> search2(String key);
}