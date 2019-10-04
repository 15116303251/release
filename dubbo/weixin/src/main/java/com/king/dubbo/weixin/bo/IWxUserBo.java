package com.king.dubbo.weixin.bo;

import com.king.dubbo.entities.model.wx.WxUserInfo;

public interface IWxUserBo extends IAbstractBo {

    /**
     * @description 从微信服务器拉取所有的微信用户openid,并将openid进行保存
     * @param token
     * @param nextOpenid
     * @return
     */
    public void getWxAllUser(String token, String nextOpenid);

    /**
     * 根据openid 获取微信用户信息
     * @param openid
     * @return
     */
    public WxUserInfo getWxUserByOpenId(String openid);

}
