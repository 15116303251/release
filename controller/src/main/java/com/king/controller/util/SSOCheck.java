package com.king.controller.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class SSOCheck {


    public static boolean CheckCookie(){

        ServletRequestAttributes servletRequestAttributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=servletRequestAttributes.getRequest();

        Cookie[] cookies=request.getCookies();

        if(cookies!=null){
            for(int i=0;i<cookies.length;i++){
                if("ssocookie".equalsIgnoreCase(cookies[i].getName()) && "sso".equalsIgnoreCase(cookies[i].getValue())){
                   return true;
                }
            }
        }
        return false;
    }
}
