package com.king.dubbo.service.weixin;


import com.king.dubbo.entities.model.Constrant;
import java.util.List;

public interface IParamConstantService extends AbstractSerivce {

    public List<Constrant> selectAllConstrant();
}
