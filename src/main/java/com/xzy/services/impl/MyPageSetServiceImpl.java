package com.xzy.services.impl;

import com.xzy.dao.MyPageSetMapper;
import com.xzy.model.User;
import com.xzy.services.MyPageSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("SetPage")
public class MyPageSetServiceImpl implements MyPageSetService {
    @Autowired
    private MyPageSetMapper ms;


    public User UserInfo(User user) throws Exception {
        User us = ms.UserInfo(user);
        return us;
    }

    @Override
    public void SetUser(Map map) throws Exception{
        ms.SetUser(map);
        System.out.println("修改成功");
    }

    @Override
    public User CheckPwd(String oldPwd) throws Exception {
        return ms.CheckPwd(oldPwd);
    }

    @Override
    public void SetPwd(Map map) throws Exception {
        ms.setPwd(map);
        System.out.println("修改成功");
    }
}
