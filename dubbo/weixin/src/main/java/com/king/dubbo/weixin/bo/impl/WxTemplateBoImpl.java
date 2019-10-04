package com.king.dubbo.weixin.bo.impl;

import com.king.dubbo.weixin.bo.IWxTemplateBo;
import com.king.dubbo.weixin.dao.WxReplyTemplateInfoMapper;
import com.king.dubbo.weixin.dao.WxTemplateInfoMapper;
import com.king.dubbo.entities.model.wx.WxReplyTemplateInfo;
import com.king.dubbo.entities.model.wx.WxTemplateInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WxTemplateBoImpl implements IWxTemplateBo {

    @Autowired
    WxTemplateInfoMapper wxTemplateInfoMapper;

    @Autowired
    WxReplyTemplateInfoMapper wxReplyTemplateInfoMapper;

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

    @Override
    public WxTemplateInfo getTemplateInfoByTemKey(String temKey) {
        return wxTemplateInfoMapper.selectByPrimaryKey(temKey);
    }

    public WxReplyTemplateInfo getWxTemplateInfoById(Integer id){
        return  wxReplyTemplateInfoMapper.selectByPrimaryKey(id);
    }
}
