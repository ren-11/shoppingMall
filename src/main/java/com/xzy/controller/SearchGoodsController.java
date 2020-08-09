package com.xzy.controller;


import com.xzy.model.User;
import com.xzy.services.SearchService;
import com.xzy.vo.goods_tableVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/goods")
public class SearchGoodsController {
    @Resource
    SearchService searchService;

    //搜索并写入搜索记录
    @RequestMapping("/search2")
    public ModelAndView search2(@RequestParam(required = false) String key, HttpServletRequest req){
        User user= (User) req.getSession().getAttribute("user");

        if (user!=null)
        {
            Jedis jedis=new Jedis();
            System.out.println("连接Redis成功"+user);
            jedis.sadd(Long.toString(user.getUserId()),key);
        }
        List<goods_tableVO>  goods_tableVOList=searchService.search2(key);
        ModelAndView mav=new ModelAndView("searchgoods2");
        mav.addObject("goodslist",goods_tableVOList);
        return mav;
    }


//显示搜索记录
    @RequestMapping("/searchkey")
    public ModelAndView searchkey(HttpServletRequest req){
        User user= (User) req.getSession().getAttribute("user");

        ModelAndView mav=new ModelAndView("searchkey");
        if (user!=null)
        {
            Jedis jedis=new Jedis();
            List searchkey=  jedis.srandmember(Long.toString(user.getUserId()),10);
            mav.addObject("searchkey",searchkey);
            return  mav;
        }
        return  mav;
    }


//删除搜索记录
    @RequestMapping("/searchkeydel")
    public void searchkeydel(HttpServletRequest req){
        User user= (User) req.getSession().getAttribute("user");
        if (user!=null){
            Jedis jedis=new Jedis();
            jedis.del(Long.toString(user.getUserId()));
        }
    }


}
