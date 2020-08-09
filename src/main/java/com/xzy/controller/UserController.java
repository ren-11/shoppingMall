package com.xzy.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.xzy.model.User;
import com.xzy.services.UserService;
import com.xzy.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Controller //标注这是一个控制类，类名不能和注解名一样
@RequestMapping("/user")//设置访问路径
public class UserController {

    @Autowired //根据类型转载
    private UserService userService;
    @Autowired
    private HttpServletRequest request;


//    @RequestMapping("/select")//为方法设置访问路径
//    public ModelAndView selectUser() throws Exception {
//        ModelAndView mv = new ModelAndView();
//        User user = userService.getselectUser(1);
//
//
//        System.out.println(user.getUserId()+"::::"+user.getPhone()+"");
//
//        mv.addObject("user", user);
//        mv.setViewName("User");
//        return mv;
//    }
//
//    @RequestMapping("/selectall")
//    public ModelAndView userList(User usermodel){
//
//        List<User> userList=userService.getselectUsers(usermodel);
//
//        mv.addObject("userlist",userList);
//        for(int i=0;i<userList.size();i++){
//            System.out.println(userList.get(i).getUserName()+"::::"+userList.get(i).getEmail()+"::::"+userList.get(i).getUserPwd());
//            mv.addObject("user",userList.get(i));
//        }
//        return mv;
//    }

    /**
     *  @responsebody表示该方法的返回结果直接写入HTTP response body中
     * @responsebody注解一般在异步获取数据时使用，在springMVC框架时，使用@RequestMapping后，返回值通常解析为跳转路径，
     * 加上@responsebody后返回结果不会被解析为跳转路径，而是直接写入HTTP response body中。比如异步获取json数据，加上@responsebody后，
     * 会直接返回json数据。
     */


    // produce 都是用于指定响应体返回类型和编码

    //跳转注册页面（新用户注册）
    @RequestMapping("/toRegister")
    public ModelAndView toRegister(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("Register");
        return mv;
    }

    //跳转登录页面（默认验证码登录页面）
    @RequestMapping("/toLogin")
    public ModelAndView toLogin(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("login");
        return mv;
    }
    //跳转密码登录页面
    @RequestMapping("/toPwdLogin")
    public ModelAndView toPwdLogin(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("PwdLogin");
        return mv;
    }
    //跳转忘记密码页面
    @RequestMapping("/toForGetPwd")
    public ModelAndView toForGetPwd(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("ForGetPwd");
        return mv;
    }

    //用户密码登录
    @RequestMapping(value = "/PwdLogin",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView PwdLogin(@RequestParam("user_name")String userName,@RequestParam("user_pwd")String userPwd){
        User user=new User();
        ModelAndView mv=new ModelAndView();

        user.setUserName(userName);
        user.setUserPwd(MD5Utils.MD5Encode(userPwd,"utf-8"));
        User user1=userService.loginCheck(user);
        System.out.println(user.getUserName()+":::"+user.getUserPwd());

        //用户缓存加入session
        if(user1!=null){
            System.out.println("登录成功");
            mv.addObject("user_name",user1.getUserName());
            mv.addObject("msg","YES");
            mv.setViewName("page/index");
            HttpSession session=request.getSession();
            session.setAttribute("user",user1);
        }else {
            System.out.println("登录失败");
            mv.addObject("msg","NO");
            mv.setViewName("PwdLogin");
        }
        return mv;
    }

    //验证码登录
    @RequestMapping("/login")
    @ResponseBody
    public ModelAndView login(@RequestParam("phone") String phone,@RequestParam("code") String code)  {
        User user=new User();
        ModelAndView mv=new ModelAndView();
        String usercode="";
        HttpSession session=request.getSession();
        //防止空指针异常
        usercode= null!=(String) session.getAttribute(phone)?(String) session.getAttribute(phone):"";
        //用户缓存加入session
        if(usercode.equals(code)){
            user=userService.codeloginCheck(phone);
            session.setAttribute("user",user);
            mv.addObject("msg","YES");
            mv.setViewName("page/index");
        }else{
            mv.addObject("msg","NO");
            mv.setViewName("login");
            System.out.println("code: "+code);
            System.out.println("usercode: "+usercode);
            System.out.println("登录失败");
        }
        return mv;
    }

    //发送登录验证码
    @RequestMapping(value="/sendloginMsg",method = RequestMethod.POST)
    public ModelAndView sendloginMsg(@RequestParam("phone") String phone){
        SendSmsResponse ssr=null;
        //发送登录验证码模块
        if(!"".equals(phone)){

            try {
                ssr=userService.sendMsg(phone,"SMS_183240236");
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("hahahhaahhah");
            request.getSession().setAttribute(phone,ssr.getCode());
        }

        return new ModelAndView("login");
    }

    //发送注册验证码
    @RequestMapping(value="/sendRegisterMsg",method = RequestMethod.POST)
    public ModelAndView sendMsg(@RequestParam("phone") String phone){
        SendSmsResponse ssr=null;
        //发送登录验证码模块
        if(!"".equals(phone)){

            try {
                ssr=userService.sendMsg(phone,"SMS_183265218");
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("hahahhaahhah");
            request.getSession().setAttribute(phone,ssr.getCode());
        }

        return new ModelAndView("Register");
    }

    //发送重置验证码
    @RequestMapping(value="/sendpwdMsg",method = RequestMethod.POST)
    public ModelAndView sendpwdMsg(@RequestParam("phone") String phone){
        SendSmsResponse ssr=null;
        //发送登录验证码模块
        if(!"".equals(phone)){

            try {
                ssr=userService.sendMsg(phone,"SMS_183245654");
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println("hahahhaahhah");
            request.getSession().setAttribute(phone,ssr.getCode());
        }

        return new ModelAndView("ForGetPwd");
    }


    //忘记密码修改密码
    @RequestMapping(value = "/ForGetPwd",method = RequestMethod.POST)
    public ModelAndView ForGetPwd(@RequestParam("code") String code,@RequestParam("phone") String phone,@RequestParam("user_pwd") String user_newpwd){
        ModelAndView mv=new ModelAndView();
        User user=new User();
        HttpSession session=request.getSession();
        String usercode="";
        usercode=null!=session.getAttribute(phone)? (String) session.getAttribute(phone) :"";
        if(usercode.equals(code)){
            user.setPhone(phone);
            user.setUserPwd(MD5Utils.MD5Encode(user_newpwd,"utf-8"));
            mv.setViewName("PwdLogin");
            mv.addObject("msg","YES");
        }else {
            mv.setViewName("ForGetPwd");
            mv.addObject("msg", "NO");
        }

        return  mv;
    }

    //注册
    @RequestMapping(value="/Register",method = RequestMethod.POST)
    public ModelAndView Register(@RequestParam("user_name") String userName, @RequestParam("phone") String phone,
                                 @RequestParam("user_pwd") String user_pwd, @RequestParam("email") String email, @RequestParam("code")String code,
                                 @RequestParam("user_birth") Date user_birth, @RequestParam("user_real_name") String user_real_name,
                                 @RequestParam("user_sex") String user_sex){
        ModelAndView mv=new ModelAndView();
        User user=new User();

        System.out.println(user_birth+":::"+user_real_name+":::"+user_sex);

        String usercode="";
        HttpSession session=request.getSession();
        //防止空指针异常
        usercode= null!=(String) session.getAttribute(phone)?(String) session.getAttribute(phone):"";
        if(usercode.equals(code)){
            user.setUserName(userName);
            user.setPhone(phone);
            user.setEmail(email);
            user.setUserPwd(MD5Utils.MD5Encode(user_pwd,"utf-8"));
            user.setUserBirth(user_birth);
            user.setUserRealName(user_real_name);
            user.setUserSex(user_sex);
            //获取当前日期
            LocalDate date=LocalDate.now();
            DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
            System.out.println(date.format(formatter));
            user.setDate(new Date(System.currentTimeMillis()));

            userService.register(user);
            mv.setViewName("login");
            mv.addObject("msg","YES");
        }else {
            mv.setViewName("Register");
            mv.addObject("msg","NO");
        }

        return mv;
    }
}
