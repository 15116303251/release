package com.king.dubbo.weixin.bo;


import com.king.dubbo.entities.model.wx.WxNews;
import com.king.dubbo.entities.model.wx.pojo.article.ArticleNewForSendToAllUser;
import com.king.dubbo.entities.model.wx.pojo.message.NewArticleMessage;

public interface IWxNewArticleInfoBo extends IAbstractBo{

    /**
     * @description 查询该编号的对应的所有的图文消息
     * @author shenwang
     * @return
     */
    public String getAllArticleInfoByCode(String code);

    //----------------------------------------------------------------------------------------------------------群发消息
    /**
     * @description 群发图文消息给某个标签的用户
     * @param articleNewForSendToAllUser
     * @return
     */
    public String sendArticleNewToTagUser(ArticleNewForSendToAllUser articleNewForSendToAllUser);

    /**
     * @description 图文信息的mediaId
     * @Param content 上传的图文信息的内容
     * @return
     */
    public String getSendArticleNewMediaId(String code);

    //----------------------------------------------------------------------------------------------------------群发消息
    /**
     * @description 根据主键获取图文消息
     * @param id
     * @return
     */
    public WxNews getWxNewsByPrimaryKey(Integer id);

    /**
     * @description 获取图文消息组装的Content
     * @param code
     * @return
     */
    public NewArticleMessage getHandleDealNewsArticle(String code);
}
