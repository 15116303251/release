package com.king.dubbo.weixin.dao;

import com.king.dubbo.entities.model.Constrant;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author shenwang
 * @description 用于操作数据库中常量的底层操作
 */
@Mapper
public interface ConstrantMapper {

    /**
     * 获取数据库中所有的常量
     * @return
     */
    public List<Constrant> selectAllConstrant();
}
