package com.king.dubbo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ConstantLoadSchedule {

    @Scheduled(cron = "0/30 * * * * ?")
    public void loadConstantToRedis(){

    }


}
