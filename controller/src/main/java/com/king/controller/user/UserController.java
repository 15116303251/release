package com.king.controller.user;

import com.king.controller.util.SSOCheck;
import com.king.dubbo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @ResponseBody
    public String login(HttpServletResponse response,String username,String password){

        //1、查询数据库跟用户输入的姓名与账号进行对比
        //UserInfo userInfo=userService.getUserByUserName(username);


        if(username!=null && password!=null){
            //2、如果是ok，就设置cookie 的值
            Cookie cookie=new Cookie("ssocookie","sso");
            cookie.setPath("/");
            response.addCookie(cookie);
        }else{
            return "请重新登录";
        }
        return "登录成功";
    }

    /**
     * 应用程序1
     * @return
     */
    @RequestMapping("/program1")
    public String demo1(){

        if(SSOCheck.CheckCookie()){
            return "登录成功1";
        }else{
            return "redirect:/api/user/login?username=1&password=1";
        }
    }


    /**
     * 应用程序2
     * @return
     */
    @RequestMapping("/program2")
    public String demo2(){

        if(SSOCheck.CheckCookie()){
            return "登录成功2";
        }else{
            return "redirect:/api/user/login?username=1&password=1";
        }
    }

}
