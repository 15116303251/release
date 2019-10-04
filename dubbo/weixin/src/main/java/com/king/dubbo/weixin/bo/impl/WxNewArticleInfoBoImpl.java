package com.king.dubbo.weixin.bo.impl;


import com.alibaba.fastjson.JSONObject;
import com.king.dubbo.weixin.bo.IWxMenuBo;
import com.king.dubbo.weixin.bo.IWxNewArticleInfoBo;
import com.king.dubbo.weixin.dao.WxArticleInfoMapper;
import com.king.dubbo.weixin.dao.WxNewsMapper;
import com.king.dubbo.entities.model.wx.WxArticleInfo;
import com.king.dubbo.entities.model.wx.WxNews;
import com.king.dubbo.entities.model.wx.pojo.article.Article;
import com.king.dubbo.entities.model.wx.pojo.article.ArticleNewForSendToAllUser;
import com.king.dubbo.entities.model.wx.pojo.article.Articles;
import com.king.dubbo.entities.model.wx.pojo.message.NewArticleMessage;
import com.king.dubbo.entities.model.wx.pojo.message.item;
import com.king.dubbo.weixin.utils.WeiXinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 微信图文消息
 * @author shenwang
 */
@Component
public class WxNewArticleInfoBoImpl implements IWxNewArticleInfoBo {

    @Autowired
    WxArticleInfoMapper wxArticleInfoMapper;
    @Autowired
    IWxMenuBo wxMenuBo;
    @Autowired
    WxNewsMapper wxNewsMapper;

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
    public String sendArticleNewToTagUser(ArticleNewForSendToAllUser articleNewForSendToAllUser) {
        String content= WeiXinUtil.getSendToTagUserNewArticleContent(articleNewForSendToAllUser);
        String result=WeiXinUtil.httpRequest(WeiXinUtil.sendToAllUserUrl.replace("ACCESS_TOKEN",wxMenuBo.getAccessToken()),"POST",content);
        int errcode= JSONObject.parseObject(result).getIntValue("errcode");
        if(errcode==0){
            logger.info("--群发标签用户图文消息成功");
            return "success";
        }
        logger.info("--群发标签用户图文消息失败");
        return "fail";
    }

    @Override
    public String getSendArticleNewMediaId(String code) {
        String content=getAllArticleInfoByCode(code);
        String result = WeiXinUtil.httpRequest(WeiXinUtil.getPictureArticleUrl.replace("ACCESS_TOKEN", wxMenuBo.getAccessToken()), "POST", content);
        JSONObject jsonObject = JSONObject.parseObject(result);
        if(jsonObject.getString("media_id")!=null){
            logger.info("--获取图文的mediaId成功");
            return jsonObject.getString("media_id");
        }else{
            logger.info("--获取图文的mediaId失败");
            return null;
        }
    }

    @Override
    public String getAllArticleInfoByCode(String code) {
        List<WxArticleInfo>list=wxArticleInfoMapper.getAllArticleInfoByCode(code);
        List<Article> articleList=new ArrayList<>();
        if(list!=null && list.size()>0){
            for(int i=0;i<list.size();i++){
                Article article=new Article();
                article.setAuthor(list.get(i).getAuthor());
                article.setContent(list.get(i).getContent());
                article.setContent_source_url(list.get(i).getPicurl());
                article.setDigest(list.get(i).getDigest());
                article.setNeed_open_comment(list.get(i).getNeedOpenComment());
                article.setOnly_fans_can_comment(list.get(i).getOnlyFansCanComment());
                article.setShow_cover_pic(list.get(i).getShowCoverPic());
                article.setThumb_media_id(list.get(i).getThumMediaId());
                article.setTitle(list.get(i).getTitle());
                articleList.add(article);
            }
        }
        Articles articles=new Articles();
        articles.setArticles(articleList);
        return JSONObject.toJSONString(articles);
    }


    @Override
    public WxNews getWxNewsByPrimaryKey(Integer id) {
        return wxNewsMapper.selectByPrimaryKey(id);
    }

    @Override
    public NewArticleMessage getHandleDealNewsArticle(String code) {
        List<WxArticleInfo>list=wxArticleInfoMapper.getAllArticleInfoByCode(code);
        List<item> itemList=new ArrayList<>();
        if(list!=null && list.size()>0){
            for(int i=0;i<list.size();i++){
                item item=new item();
                item.setDescription(list.get(i).getDescription());
                item.setPicUrl(list.get(i).getPicurl());
                item.setTitle(list.get(i).getTitle());
                item.setUrl(list.get(i).getUrl());
                itemList.add(item);
            }
        }
        NewArticleMessage articles=new NewArticleMessage();
        articles.setArticles(itemList);
        articles.setArticleCount(""+list.size());
        return articles;
    }

}
