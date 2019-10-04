package com.king.dubbo;

import com.king.dubbo.entities.model.Constrant;
import com.king.dubbo.service.weixin.IParamConstantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleTask {

    @Autowired
    IParamConstantService paramConstantService;

    public void loadConstantToRedis(){
        List<Constrant>constrantList= paramConstantService.selectAllConstrant();



    }
}
