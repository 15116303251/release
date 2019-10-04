package com.king.dubbo.weixin.service;

import com.king.dubbo.entities.model.wx.pojo.article.ArticleNewForSendToAllUser;
import com.king.dubbo.service.weixin.IWxNewArticleInfoService;
import com.king.dubbo.weixin.bo.IWxNewArticleInfoBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("wxNewArticleInfoService")
public class WxNewArticleInfoServiceImpl implements IWxNewArticleInfoService {

    @Autowired
    IWxNewArticleInfoBo wxNewArticleInfoBo;

    @Override
    public String sendAllUserArticleNewInfo(String code) {

        return null;
    }

    @Override
    public void sendArticleNewToTagUser(String code, ArticleNewForSendToAllUser articleNewForSendToAllUser) {
        packageArticleNewForSendToAllUser(code,articleNewForSendToAllUser);
        wxNewArticleInfoBo.sendArticleNewToTagUser(articleNewForSendToAllUser);
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


    /**
     * @descriptiuon 组装要群发送给标签用户的数据
     * @param code
     * @param articleNewForSendToAllUser
     * @return
     */
    public void packageArticleNewForSendToAllUser(String code,ArticleNewForSendToAllUser articleNewForSendToAllUser){
        String mediaId=wxNewArticleInfoBo.getSendArticleNewMediaId(code);
        articleNewForSendToAllUser.setMediaId(mediaId);
    }
}
