package com.xzy.services;

import com.xzy.model.User;

import java.util.Map;

public interface MyPageSetService {

    //查询用户信息
    User UserInfo(User user) throws Exception;

    //修改用户信息
    void SetUser(Map map) throws Exception;

    //检查原密码
    User CheckPwd(String oldPwd) throws Exception;

    //修改新密码
    void SetPwd(Map map) throws Exception;
}
