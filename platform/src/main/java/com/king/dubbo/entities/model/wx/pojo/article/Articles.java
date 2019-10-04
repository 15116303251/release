package com.king.dubbo.entities.model.wx.pojo.article;

import java.io.Serializable;
import java.util.List;

/**
 * @description 用于群发的微信文章
 * @author shenwang
 */
public class Articles implements Serializable {

    List<Article> articles;

    public Articles(List<Article> articles) {
        this.articles = articles;
    }

    public Articles() {
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
