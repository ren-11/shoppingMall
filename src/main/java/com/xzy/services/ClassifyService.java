package com.xzy.services;

import com.xzy.model.GoodsTable;

import java.util.List;

public interface ClassifyService {
    List<GoodsTable> classifyleft(long fid);//推荐分类下面的几个大分类
    List<GoodsTable> hotclassify();//热门分类
    List<GoodsTable> recommendclassiify();//为你推荐
}
