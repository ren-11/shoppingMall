package com.xzy.dao;

import com.xzy.model.User;

public interface UserMapper {
    //密码登录验证
    public User loginCheck(User user);
    //注册
    public int register(User user);
    //修改密码
    public int updatepwd(User user);
    //验证码登录验证
    public User codeloginCheck(String phone);
    //退出登录
    //public void loginOut(User user);
}