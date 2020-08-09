package com.xzy.services;

import com.xzy.model.GoodsTable;
import com.xzy.model.Seller;

import java.util.List;

public interface FindService {
    //查询用户收藏的商家
    public List<Seller> finduserCollect(int user_ID);
    //查询用户收藏商家中被收藏最多的商品
    public List<GoodsTable> findcollectGoods(int user_ID);
    //查询商品所属商家
    public Seller findseller(int goods_id);
}
