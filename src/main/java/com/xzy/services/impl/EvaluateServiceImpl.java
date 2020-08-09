package com.xzy.services.impl;

import com.xzy.dao.EvaluateMapper;
import com.xzy.model.Evaluate;
import com.xzy.model.User;
import com.xzy.services.EvaluateService;
import com.xzy.vo.Evaluatevo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EvaluateServiceImpl implements EvaluateService {
    @Autowired
    private EvaluateMapper em;

    @Override
    public List<Evaluatevo> getalleva(Integer gid) {
        List<Evaluatevo> evaluatevoList= new ArrayList<>();

        List<com.xzy.model.Evaluate> evaluateList=em.findPage(gid);
        if(!evaluateList.isEmpty()){
            for (Evaluate evaluate :evaluateList) {
                Evaluatevo evaluatevo=new Evaluatevo();
                //查询头像和名字
                User user=em.getuser(evaluate.getUserId());
                evaluatevo.setDialogbox(evaluate.getDialogbox());
                evaluatevo.setDate(evaluate.getDate());
                evaluatevo.setUserName(user.getUserName());
                evaluatevo.setUserPic(user.getUserPic());
                evaluatevoList.add(evaluatevo);
            }
        }

        return evaluatevoList;
    }

    @Override
    public boolean getorderID(Integer orderId) {
        Integer bnum = em.getorderID(orderId);//看是否能返回订单号
        if(bnum == null){
            return false;
        }else return true;
    }

    @Override
    public Integer count(Integer gid) {
        return em.count(gid);
    }

    @Override
    public Integer getOrderState(Integer oid) {
        return em.getOrderState(oid);
    }

    @Override
    public Integer getGid(Integer oid) {
        return em.getGid(oid);
    }

    @Override
    public void setEvaluate(Map map) throws Exception{
        em.setEvaluate(map);
        System.out.println("评价成功");
    }
}
