package com.king.dubbo.weixin.bo.impl;

import com.king.dubbo.weixin.bo.IWxReplyTextBo;
import com.king.dubbo.weixin.dao.WxTextMapper;
import com.king.dubbo.entities.model.wx.WxTextWithBLOBs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WxReplyTextBoImpl implements IWxReplyTextBo {

    @Autowired
    WxTextMapper wxTextMapper;

    @Override
    public Integer insertOne(Object object) {
        return null;
    }

    @Override
    public Object selectOne(Integer id) {
         WxTextWithBLOBs wxText=wxTextMapper.selectByPrimaryKey(id);
        return wxText;
    }

    @Override
    public Integer updateOne(Object object) {
        return null;
    }

    @Override
    public Integer deleteOne(Integer id) {
        return null;
    }
}
