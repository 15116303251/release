package com.king.dubbo.weixin.bo.impl;

import com.king.dubbo.weixin.bo.IWxActivityAssignmentBo;
import com.king.dubbo.weixin.dao.WxAssignmentActivityMapper;
import com.king.dubbo.entities.model.wx.WxAssignmentActivity;
import com.king.dubbo.entities.model.wx.WxAssignmentActivityExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WxActivityAssignmentBoImpl implements IWxActivityAssignmentBo {

    @Autowired
    WxAssignmentActivityMapper wxAssignmentActivityMapper;

    @Override
    public WxAssignmentActivity queryWxAssignmentActivityByTypeAndContent(String type, String content) {

        WxAssignmentActivityExample example=new WxAssignmentActivityExample();
        example.createCriteria().andKeywordTypeEqualTo(type);
        if(content!=null){
            example.createCriteria().andKeywordContentEqualTo(content);

        }

        List<WxAssignmentActivity> activity=wxAssignmentActivityMapper.selectByExample(example);

        if(activity != null && activity.size()>0){
            return activity.get(0);
        }
        return null;
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
}
