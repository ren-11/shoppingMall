package com.xzy.controller;
/**
 * Create by Intellij IDEA.
 * User:朱星鑫
 */

import com.alibaba.fastjson.JSONObject;
import com.xzy.model.GoodsTable;
import com.xzy.services.ClassifyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.annotation.Resource;

import java.util.List;

@Controller
@ResponseBody
public class ClassifyController {
    @Resource
    private ClassifyService cf;

    //传入fid查询分类目录以及子目录
    //fid对应着数据库的first_id
    @RequestMapping(value = "/classify",produces = "text/html;charset=UTF-8")
    public String classify(long fid){
        List<GoodsTable> classifyname = null;
        classifyname = cf.classifyleft(fid);
        return JSONObject.toJSONString(classifyname);
    }

    //推荐分类，根据评论数取前几
    @RequestMapping(value = "/classify/recommend",produces = "text/html;charset=UTF-8")
    public String RecommendClassify(){
        List<GoodsTable> recommendName = null;

        recommendName = cf.recommendclassiify();//为你推荐

        return JSONObject.toJSONString(recommendName);
    }
    //热门分类，根据点击数取前几
    @RequestMapping(value = "/classify/hot",produces = "text/html;charset=UTF-8")
    public String HotClassify(){
        List<GoodsTable> hotName = null;
        hotName = cf.hotclassify();//热门分类
        return JSONObject.toJSONString(hotName);
    }



}
