package com.xzy.controller;
/**
 * Create by Intellij IDEA.
 * User:朱星鑫
 */
import com.alibaba.fastjson.JSONObject;
import com.xzy.model.User;
import com.xzy.services.EvaluateService;
import com.xzy.vo.Evaluatevo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/evaluate")
@ResponseBody
public class EvaluateController {
    @Autowired
    private EvaluateService em;

    //显示当前商品所有评价
    @RequestMapping(value = "/showall",produces = {"application/json;charset=UTF-8"})
    public String findallEva(Integer gid){
        //List<Evaluatevo> evaluatevoList= new ArrayList<>();
        List<Evaluatevo> evaluatevosList = em.getalleva(gid);

        return JSONObject.toJSONString(evaluatevosList);
    }

    @RequestMapping(value = "/upeveluate",method = RequestMethod.POST)
    public void upEveluate(String dialogbox, Integer orderId, HttpServletRequest hq, HttpServletResponse hp, Model md) throws Exception {
        ModelAndView mv = new ModelAndView();
        User user = (User) hq.getSession().getAttribute("user");
        if(user == null){
            hp.sendRedirect(hq.getContextPath()+"/index.jsp");
        }else {
            int userId = user.getUserId();
            Integer orderState = em.getOrderState(orderId);
            Integer gid = em.getGid(orderId);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(System.currentTimeMillis());//获取时间
            Integer comnum = em.count(gid);//评价累加数
            boolean bnum = em.getorderID(orderId);
            //判断orderId是否合法
            if (bnum == true) {
                Map map = new HashMap();
                if (orderState == 1) {
                    if (dialogbox.isEmpty() || dialogbox.length() > 200) {
                        md.addAttribute("error", "评价为空或评价大于200字");
                    } else {
                        long num = comnum + 1;
                        map.put("dialogbox", dialogbox);
                        map.put("userId", userId);
                        map.put("gid", gid);
                        map.put("date", formatter.format(date));
                        map.put("num", num);
                        em.setEvaluate(map);
                        mv.setViewName("success");
                    }
                } else {
                    md.addAttribute("error", "暂不能评价");
                }
            } else {
                md.addAttribute("error", "未查到订单");
            }
        }
    }
    @RequestMapping("/deleteEveluate")
    public void delete(){

    }

}
