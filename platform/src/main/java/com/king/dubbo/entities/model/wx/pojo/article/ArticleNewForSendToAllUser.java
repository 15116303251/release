package com.king.dubbo.entities.model.wx.pojo.article;

/**
 * @description 用于群发微信消息时的相关的参数类
 * @author shenwang
 */
public class ArticleNewForSendToAllUser {

    //是否发给全部人
    private boolean isToAll=false;

    //标签id
    private Integer tagId;

    //群发为图文时的mediaId
    private String mediaId;

    //群发的内容的类型
    private String type;

    //当参数设置为0时，文章判定为转载，将停止群发操作，1为允许
    private Integer sendIgnoreReprint=0;

    public boolean isToAll() {
        return isToAll;
    }

    public void setToAll(boolean toAll) {
        isToAll = toAll;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSendIgnoreReprint() {
        return sendIgnoreReprint;
    }

    public void setSendIgnoreReprint(Integer sendIgnoreReprint) {
        this.sendIgnoreReprint = sendIgnoreReprint;
    }
}
