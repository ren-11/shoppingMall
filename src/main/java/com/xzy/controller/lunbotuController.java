package com.xzy.controller;

import com.xzy.model.bigpic;
import com.xzy.services.lunbotuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class lunbotuController {
    @Resource
    lunbotuService lunbotuservice;

    @RequestMapping("/lunbotu")
    public ModelAndView lunbotu(){
        List<bigpic> bigpicList=lunbotuservice.getTU();
        ModelAndView mav=new ModelAndView("lunbotu");
        mav.addObject("lunbotulist",bigpicList);
        return mav;
    }
}
