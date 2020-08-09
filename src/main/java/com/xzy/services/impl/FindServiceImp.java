package com.xzy.services.impl;

import com.xzy.dao.FindMapper;
import com.xzy.model.GoodsTable;
import com.xzy.model.Seller;
import com.xzy.model.USCollect;
import com.xzy.services.FindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindServiceImp implements FindService {

    @Autowired
    private FindMapper findMapper;

    //找出用户收藏店铺
    @Override
    public List<Seller> finduserCollect(int user_ID) {
        //查询用户收藏店铺id
        List<USCollect> list= findMapper.getuserCollect(1);

        List<Seller> sellerList=findMapper.getuserseller(user_ID);
//        for (int i=0;i<list.size();i++){
//            //
//            sellerList.add(findMapper.getsellertPic(list.get(i).getSellerId()));
//        }
//        if(!sellerList.isEmpty()){
//            return sellerList;
//        }

        return sellerList;
    }
    //查询用户收藏商家中被收藏最多的商品
    @Override
    public List<GoodsTable> findcollectGoods(int user_ID) {
        //得到商家商品
        List<GoodsTable> goodsTables=findMapper.getsellerGoods(user_ID);
        //得到商品收藏最多的十个
        List<GoodsTable> goods=findMapper.getcollectGoods(goodsTables);
        //得到商品图片和商品描述
        List<GoodsTable> goodspic=findMapper.getGoodspic(goods);
        return goodspic;
    }

    //查询商品所属商家
    @Override
    public Seller findseller(int goods_id) {
        Seller seller=findMapper.getseller(goods_id);
        Seller sellerpic=findMapper.getsellertPic(seller.getSellerId());
        return sellerpic;
    }


}
