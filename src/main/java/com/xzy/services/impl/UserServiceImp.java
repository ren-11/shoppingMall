package com.xzy.services.impl;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.xzy.dao.UserMapper;
import com.xzy.model.User;
import com.xzy.services.UserService;
import com.xzy.utils.AliyunMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service //表示这是一个业务层，是service类 @controller是用于标注控制层组件，@Component是当某一个类不好归类的时候用 这个注解
public class UserServiceImp implements UserService {

    @Autowired  //@Autowired默认按类型装配（这个注解是属业spring的），
    private UserMapper userMapper;
    @Override
    //登录验证

    public User loginCheck(User user) {
        User u=userMapper.loginCheck(user);
        return u;
    }

    //注册
    @Override
    public int register(User user) {
        int n=userMapper.register(user);
        return n;
    }



    //修改密码
    @Override
    public int updatepwd(User user) {
        int a=userMapper.updatepwd(user);
        return a;
    }

    //发送验证码
    @Override
    public SendSmsResponse sendMsg(String phone, String TemplateCode) throws Exception {
        SendSmsResponse ssr=AliyunMessageUtils.sendMsg(phone,TemplateCode);
        return ssr;
    }

    @Override
    public User codeloginCheck(String phone) {
        User user=null;
        user=userMapper.codeloginCheck(phone);
        return user;
    }
}
