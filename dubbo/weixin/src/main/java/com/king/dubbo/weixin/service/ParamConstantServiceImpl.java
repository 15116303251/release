package com.king.dubbo.weixin.service;

import com.king.dubbo.entities.model.Constrant;
import com.king.dubbo.redis.config.RedisHelper;
import com.king.dubbo.service.weixin.IParamConstantService;
import com.king.dubbo.weixin.bo.IParamConstantBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service("paramConstantService")
public class ParamConstantServiceImpl implements IParamConstantService {

    @Autowired
    IParamConstantBo paramConstantBo;
    @Autowired
    RedisHelper redisHelper;

    @Override
    public List<Constrant> selectAllConstrant() {
        return paramConstantBo.selectAllConstrant();
    }



    @Override
    public Integer insertOne(Object object) {
        return null;
    }

    @Override
    public Object selectOne(Integer id) {
        return null;
    }

    @Override
    public Integer updateOne(Object object) {
        return null;
    }

    @Override
    public Integer deleteOne(Integer id) {
        return null;
    }

    @PostConstruct
    public void loadConstantToRedis(){
        logger.info("正在初始化微信常量到缓存");
        List<Constrant>constrantList=paramConstantBo.selectAllConstrant();

        if(constrantList!=null && constrantList.size()>=0){
            for(int i=0;i<constrantList.size();i++){
                redisHelper.putObjectValue(constrantList.get(i).getKey(),constrantList.get(i).getContent());
            }
        }
        logger.info("初始化微信常量到缓存结束");

    }
}
