package com.king.dubbo.entities.model.wx.pojo.message;

import java.util.List;

/**
 * @desciption 图文消息
 */
public class NewArticleMessage extends BaseMessage {

    private String ArticleCount;

    private List<item> Articles;

    public String getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(String articleCount) {
        ArticleCount = articleCount;
    }

    public List<item> getArticles() {
        return Articles;
    }

    public void setArticles(List<item> articles) {
        Articles = articles;
    }
}
