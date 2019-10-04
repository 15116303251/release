package com.king.dubbo.service.weixin;

public interface IWxUserService extends AbstractSerivce {

    /**
     * @description 从微信服务器拉取所有的微信用户openid,并将openid进行保存
     * @return
     */
    public void gainWxAllUser();
}
