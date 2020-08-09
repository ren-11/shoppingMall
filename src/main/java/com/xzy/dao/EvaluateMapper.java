package com.xzy.dao;

import com.xzy.model.Evaluate;
import com.xzy.model.User;

import java.util.List;
import java.util.Map;

public interface EvaluateMapper {
    //查询总评价数
    Integer count(Integer gid);
    //查询订单状态
    Integer getOrderState(Integer oid);
    //查询商品id,用户id
    Integer getGid(Integer oid);
    //插入评论
    void setEvaluate(Map map);
    //用户头像
    User getUPic(int uid);
    //根据goodsId查询用户评论
    public List<Evaluate> findPage(Integer gid);
    //根据用户id查询用户头像
    public User getuser(int userId);
    //查询订单ID
    Integer getorderID(Integer orderId);
}