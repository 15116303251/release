package com.king.dubbo.weixin.bo.impl;

import com.king.dubbo.weixin.bo.IParamConstantBo;
import com.king.dubbo.weixin.dao.ConstrantMapper;
import com.king.dubbo.entities.model.Constrant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description 数据库常量的查询
 * @author shenwang
 */
@Component
public class ParamConstantBoImpl implements IParamConstantBo {

    @Autowired
    ConstrantMapper constrantMapper;

    @Override
    public List<Constrant> selectAllConstrant() {
        return constrantMapper.selectAllConstrant();
    }
}
