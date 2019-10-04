package com.king.dubbo.weixin.bo;


import com.king.dubbo.entities.model.wx.WxAssignmentActivity;

public interface IWxActivityAssignmentBo extends IAbstractBo{

    /**
     * @description 通过消息的类型以及内容查询微信活动信息
     * @param type 类型
     * @param content 内容
     * @return
     */
    public WxAssignmentActivity queryWxAssignmentActivityByTypeAndContent(String type, String content);
}
