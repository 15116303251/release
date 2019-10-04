package com.king.controller.weixin;


import com.king.dubbo.service.weixin.IWxMainService;
import com.king.dubbo.service.weixin.IWxMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
public class WxController extends BaseController{

    @Autowired
    IWxMainService wxMainService;
    /**
     *  处理第一次的回调验证
     * @param request
     * @param response
     */
    @RequestMapping(value = "/wx/coreServlet.htm",method = RequestMethod.GET)
    public void getBackToUs(HttpServletRequest request, HttpServletResponse response){

        logger.info("微信进行第一次的回调校验");

        String signature = request.getParameter("signature");
        String timeStamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echoStr = request.getParameter("echostr");

        PrintWriter out=null;
        try{
            String result=wxMainService.firstBack(signature,timeStamp,nonce,echoStr);
            response.getWriter().print(result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(out!=null){
                out.close();
            }
        }

        logger.info("微信的回调get方法结束");
    }

    /**
     * 处理第一次回调之后的大部分调用，除了授权部分
     * @param request
     * @param response
     */
    @RequestMapping(value = "/wx/coreServlet.htm",method = RequestMethod.POST)
    public void postBackToUs(HttpServletRequest request,HttpServletResponse response){
        try {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");

            String signature = request.getParameter("signature");
            String timeStamp = request.getParameter("timestamp");
            String nonce = request.getParameter("nonce");

            StringBuffer stringBuffer=null;
            try {
                InputStream inputStream=request.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                stringBuffer=new StringBuffer();
                String line=null;
                while((line=bufferedReader.readLine())!=null){
                    stringBuffer.append(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            String result=wxMainService.checkSignatureAndDecrypt(signature,timeStamp,nonce,stringBuffer.toString());
            logger.info("--后台对用户的回复结果--"+result);
            PrintWriter out=response.getWriter();
            out.print(result);
            out.close();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
