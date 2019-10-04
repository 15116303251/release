package com.king.dubbo.entities.model.wx.pojo.message;


/**
 * @description 文本的消息类型
 */
public class TextMessage extends BaseMessage {

    private String Content;
    private long MsgId;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }
}
