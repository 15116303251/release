package com.king.dubbo.service.weixin;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author shenwang
 * @description 抽象服务类的接口
 */
public interface AbstractSerivce {

    public Logger logger= LogManager.getLogger(AbstractSerivce.class);

    public Integer insertOne(Object object);

    public Object selectOne(Integer id);

    public Integer updateOne(Object object);

    public Integer deleteOne(Integer id);
}
