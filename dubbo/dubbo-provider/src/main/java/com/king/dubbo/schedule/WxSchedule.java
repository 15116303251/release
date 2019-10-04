package com.king.dubbo.schedule;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.king.dubbo.service.weixin.IWxMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WxSchedule {

    private Logger logger= LogManager.getLogger(WxSchedule.class);
    @Autowired
    IWxMenuService wxMenuService;

    /**
     * 创建微信菜单的定时器
     */
    @Scheduled(cron = " 59 59 23 * * ?" )
    public void createMenu(){
        try{
            logger.info("生成菜单的定时器开始");
            wxMenuService.createMenu("ENABLE",1,-1);
            logger.info("生成菜单的定时器结束");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Scheduled(cron = "0 /30 * * *  ?")
    public void refleshAccessToken(){
        try{
            logger.info("重新刷新接口调用的access_token开始");
            wxMenuService.updateAccessToken();
            logger.info("重新刷新接口调用的access_token结束");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
