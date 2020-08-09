package com.xzy.utils;

import com.alibaba.fastjson.JSONObject;
import com.xzy.model.User;

import java.security.MessageDigest;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MD5Utils {
    private static final String hexDigIts[] = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

    /**
     * MD5加密
     * @param origin 字符
     * @param charsetname 编码
     * @return
     */
    public static String MD5Encode(String origin, String charsetname){
        String resultString = null;
        try{
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if(null == charsetname || "".equals(charsetname)){
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            }else{
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        }catch (Exception e){
        }
        return resultString;
    }


    public static String byteArrayToHexString(byte b[]){
        StringBuffer resultSb = new StringBuffer();
        for(int i = 0; i < b.length; i++){
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    public static String byteToHexString(byte b){
        int n = b;
        if(n < 0){
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigIts[d1] + hexDigIts[d2];
    }

    public static void main(String[] args){
        String pwd="0123456789012345";
        System.out.println("加密前："+pwd);
        System.out.println("md5加密后"+MD5Encode(pwd,"utf-8"));

        User user=new User();
        user.setUserPwd("123");
        user.setUserName("haha");
        user.setEmail("");
        user.setPhone(null);

        User user1=new User();
        user1.setUserPwd("1234");
        user1.setUserName("hahaha");
        user1.setEmail("123");
        user1.setPhone(null);

        List<User> list=new ArrayList<User>();
        list.add(user);
        list.add(user1);
        System.out.println(JSONObject.toJSONString("yes"));
        System.out.println(JSONObject.toJSONString(user));
        System.out.println(JSONObject.toJSONString(list));

        //获取当前时间
        LocalDate date=LocalDate.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(date.format(formatter));

        System.out.println(new Date(System.currentTimeMillis()));
    }
}
