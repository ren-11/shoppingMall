package com.xzy.dao;

import com.xzy.model.User;

import java.util.Map;


public interface MyPageSetMapper {
    //查询用户所有信息
    User UserInfo(User user) throws Exception;

    //修改用户信息
    void SetUser(Map map) throws Exception;

    //检查原密码
    User CheckPwd(String oldPwd) throws Exception;

    //修改新密码
    void setPwd(Map map) throws Exception;

}
