package com.king.dubbo.service.weixin;


import com.king.dubbo.entities.model.wx.pojo.article.ArticleNewForSendToAllUser;

public interface IWxNewArticleInfoService extends AbstractSerivce{

    /**
     * @description 查询该编号的对应的所有的图文消息
     * @author shenwang
     * @return
     */
    public String sendAllUserArticleNewInfo(String code);

    /**
     * @description 群发图文消息给微信标签用户
     * @param code
     * @param articleNewForSendToAllUser
     */
    public void sendArticleNewToTagUser(String code, ArticleNewForSendToAllUser articleNewForSendToAllUser);
}
