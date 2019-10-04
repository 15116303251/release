package com.king.dubbo.weixin.bo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface IAbstractBo {

    public Logger logger= LogManager.getLogger(IAbstractBo.class);

    public Integer insertOne(Object object);

    public Object selectOne(Integer id);

    public Integer updateOne(Object object);

    public Integer deleteOne(Integer id);

}
