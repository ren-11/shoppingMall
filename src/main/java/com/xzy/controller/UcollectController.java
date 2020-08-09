package com.xzy.controller;

import com.xzy.model.PageDiv;
import com.xzy.model.USCollect;
import com.xzy.model.UcollectMap;
import com.xzy.model.User;
import com.xzy.services.UcollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/ucollect")
@ResponseBody
public class UcollectController {
    @Autowired
    private UcollectService ucollectService;
    //显示该用户收藏的所有商品
    @RequestMapping(value = "/ulist",method = RequestMethod.GET)
    @ResponseBody
    public Model listUcollect(HttpServletRequest request ,Model model){
        User user=(User)request.getSession().getAttribute("user");
        List<UcollectMap> ls=ucollectService.ulist(1);
        model.addAttribute("ls",ls);
        return model;
    }
    //删除
    @RequestMapping("udelete")
    public Model deleteCollect(USCollect u_s_collect, Model model){
        ucollectService.udelete(u_s_collect);
        return model;
    }
    //分页显示
    @RequestMapping(value = "/upagelist",method = RequestMethod.GET)
    @ResponseBody
    public Model pagelist(HttpServletRequest request,Model model){
        User user=(User)request.getSession().getAttribute("user");
        PageDiv<UcollectMap> pd=ucollectService.pagelist(request);
        model.addAttribute("pd",pd);
        return model;
    }
}
