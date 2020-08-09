package com.xzy.controller;
/**
 * Create by Intellij IDEA.
 * User:朱星鑫
 */
import com.alibaba.fastjson.JSONObject;
import com.xzy.model.User;
import com.xzy.services.MyPageSetService;
import com.xzy.utils.FileUpload;
import com.xzy.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
@ResponseBody
public class SetPageController {
    @Autowired
    private MyPageSetService ms;
    //显示用户信息
    @RequestMapping(value = "/getUser",produces = {"application/json;charset=UTF-8"})
    public String getUser(HttpServletRequest httpServletRequest,HttpServletResponse hp) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if(user == null){
            hp.sendRedirect(httpServletRequest.getContextPath()+"/index.jsp");
        }else {
            String userName = user.getUserName();
            String userEmail = user.getEmail();
            String userPic = user.getUserPic();

            String[] userMessage = new String[]{userName, userEmail, userPic};
            return JSONObject.toJSONString(userMessage);
        }
        return null;
    }

    //修改用户信息
    @RequestMapping(value = "/setUser",method = RequestMethod.POST)
    public void setUser(String userName, String userEmail, @RequestParam(value = "userPic",required = false) CommonsMultipartFile userPic, HttpServletRequest hq, HttpServletResponse hp, Model md)
            throws Exception {
        ModelAndView mv = new ModelAndView();
        Map map = new HashMap();
        User user = (User) hq.getSession().getAttribute("user");
        if(user == null){
            hp.sendRedirect(hq.getContextPath()+"/index.jsp");
        }else{
            Integer userId = user.getUserId();
            String url;
            if(userPic == null) {
                url = user.getUserPic();
            } else {String fileName = userPic.getOriginalFilename();//获取图片名称
            String filePath = hq.getSession().getServletContext().getRealPath("img/") + fileName;//获取图片路径
            userPic.transferTo(new File(filePath));//保存图片
            url = FileUpload.upload(filePath); //上传代码
            }
            if (userName == null){ userName = user.getUserName(); }
            map.put("userName", userName);
            if(userEmail == null){userEmail = user.getEmail();}
            if(userEmail.matches("^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$")){
            map.put("email", userEmail);
            }else md.addAttribute("error","邮箱不正确！");
            map.put("userPic", url);
            map.put("userId", userId);

            ms.SetUser(map);
            md.addAttribute("msg","修改成功");
            mv.setViewName("getUser");
        }
    }

    //修改密码
    @RequestMapping(value = "/setpwd",method = RequestMethod.POST)
    public void setPwd(HttpServletRequest hq, HttpServletResponse hp, Model md) throws Exception {
        ModelAndView mv = new ModelAndView();
      String oldPwd = MD5Utils.MD5Encode(hq.getParameter("oldPwd"),"UTF-8");
      String newPwd = MD5Utils.MD5Encode(hq.getParameter("newPwd"),"UTF-8");

      User user = (User) hq.getSession().getAttribute("user");
        if(user == null){
            hp.sendRedirect(hq.getContextPath()+"/index.jsp");
        }else {
            int userId = user.getUserId();

            Map map = new HashMap();

            if (ms.CheckPwd(oldPwd) != null) {
                map.put("userPwd", newPwd);
                map.put("userId", userId);
                ms.SetPwd(map);
                mv.setViewName("getUser");
                md.addAttribute("msg","密码修改成功");
            } else {
                md.addAttribute("error", "原密码错误");
            }

        }
    }
}
