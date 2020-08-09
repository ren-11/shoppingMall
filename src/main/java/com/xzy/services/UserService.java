package com.xzy.services;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.xzy.model.User;

public interface UserService {
    //密码登录验证
    public User loginCheck(User user);
    //注册
    public int register(User user);
    //修改密码
    public int updatepwd(User user);
    //发送验证码
    public SendSmsResponse sendMsg(String phone,String TemplateCode) throws Exception;
    //验证码登录验证
    public User codeloginCheck(String phone);

    //退出登录
    //public void loginOut(User user);
}
