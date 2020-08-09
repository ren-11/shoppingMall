package com.xzy.controller;

import com.alibaba.fastjson.JSONObject;
import com.xzy.model.GoodsTable;
import com.xzy.services.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomePageController {
    @Autowired
    private HomePageService HP;
    //返回前十的热销
    @RequestMapping(value = "/hotsale",produces ={"application/json;charset=UTF-8"})
    @ResponseBody
    public String hotsale(){
        List<GoodsTable> hotGoods = HP.hotSale();
        return JSONObject.toJSONString(hotGoods);
    }
}
