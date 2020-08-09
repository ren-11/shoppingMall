package com.xzy.services;

import com.xzy.vo.Evaluatevo;

import java.util.List;
import java.util.Map;

public interface EvaluateService {

    //查询总评价数
    Integer count(Integer gid);

    //查询订单状态
    Integer getOrderState(Integer oid);

    //查询商品id,用户id
    Integer getGid(Integer oid);

    //插入评论
    void setEvaluate(Map map) throws Exception;

    //查询商品所有评论
    public List<Evaluatevo> getalleva(Integer gid);

    //查询订单Id是否存在
    boolean getorderID(Integer orderId);
}
