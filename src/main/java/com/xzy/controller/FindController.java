package com.xzy.controller;

import com.alibaba.fastjson.JSONObject;
import com.xzy.model.GoodsTable;
import com.xzy.model.Seller;
import com.xzy.services.FindService;
import com.xzy.vo.Findsellergoods;
import com.xzy.vo.Findsvo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/find") //发现页面controller
@ResponseBody
public class FindController {

    @Autowired
    private FindService findService;
    //发现页面首页请求
    @RequestMapping(value = "/finduserCollect",produces = {"application/json;charset=UTF-8"})
    public String finduserCollect(int userId){
        //初始化
        ModelAndView mv=new ModelAndView();
        Findsvo findsvo=new Findsvo();
        findsvo.setFindsellergoods(new ArrayList<Findsellergoods>() );

        //查询用户收藏店铺
        List<Seller> sellerArrayList=findService.finduserCollect(userId);
        findsvo.setSellers(sellerArrayList);

        //查询商家推送
        List<GoodsTable> goodsTable=findService.findcollectGoods(userId);

        if (!goodsTable.isEmpty()){
            for (GoodsTable goods:goodsTable) {
                Findsellergoods findsellergoods=new Findsellergoods();

                Seller seller=findService.findseller(goods.getGoodsId());

                findsellergoods.setGoodsDes(goods.getGoodsDes());
                findsellergoods.setGoodsPic(goods.getGoodsPic());
                findsellergoods.setSellerName(seller.getSellerName());
                findsellergoods.setSellerPic(seller.getSellerPic());
                findsvo.getFindsellergoods().add(findsellergoods);
            }
        }

        System.out.println(findsvo);
        mv.addObject(JSONObject.toJSONString(findsvo));

        System.out.println(JSONObject.toJSONString(findsvo));

        return JSONObject.toJSONString(findsvo);
    }


}
