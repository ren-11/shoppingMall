package com.xzy.dao;

import com.xzy.model.GoodsTable;

import java.util.List;

public interface CMapper {
    List<GoodsTable> classifyleft(long fid);
    List<GoodsTable> hotclassify();//热门分类
    List<GoodsTable> recommendclassify();//为你推荐
}
