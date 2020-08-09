package com.xzy.controller;

import com.xzy.model.Collect;
import com.xzy.model.CollectMap;
import com.xzy.model.PageDiv;
import com.xzy.model.User;
import com.xzy.services.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/collect")
@ResponseBody
public class CollectController {
    @Autowired
    private CollectService collectService;
    //显示该用户所有收藏的商品
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Model listCollect(HttpServletRequest request, Model model){
     User user=(User)request.getSession().getAttribute("user");
        List<CollectMap> ls=collectService.list(1);
        model.addAttribute("ls",ls);
        return model;
    }
    //删除
    @RequestMapping("/delete")
    @ResponseBody
    public Model deleteCollect(Collect collect, Model model){
       collectService.delete(collect);
       return model;
    }
    //分页显示
    @RequestMapping(value = "/pagelist",method = RequestMethod.GET)
    @ResponseBody
    public Model pagelist(HttpServletRequest request,Model model){
        User user=(User)request.getSession().getAttribute("user");
        PageDiv<CollectMap> pd=collectService.pagelist(request);
        model.addAttribute("pd",pd);
        return model;
    }
}
