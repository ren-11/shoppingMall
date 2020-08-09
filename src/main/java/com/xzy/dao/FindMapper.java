package com.xzy.dao;

import com.xzy.model.GoodsTable;
import com.xzy.model.SG;
import com.xzy.model.Seller;
import com.xzy.model.USCollect;

import java.util.List;

public interface FindMapper {
    //查询用户收藏商家
    public List<USCollect> getuserCollect(int userId);
    //查询商家头像
    public  Seller getsellertPic(int sellerId);

    //查询用户收藏店铺头像和名字
    public List<Seller> getuserseller(int userId);

    //查询用户收藏的商家有哪些的商品
    public List<GoodsTable> getsellerGoods(int userId);
    //查询商家的商品中收藏最多的商品 多个
    public List<GoodsTable> getcollectGoods(List<GoodsTable> GoodsTableID);
    //查询商品的图片 多个
    public List<GoodsTable> getGoodspic(List<GoodsTable> goods_id);

    //查询商品所属商家
    public Seller getseller(int goods_id);

}
