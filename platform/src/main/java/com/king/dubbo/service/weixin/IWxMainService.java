package com.king.dubbo.service.weixin;


import com.king.dubbo.entities.model.wx.WxAssignmentActivity;

import java.util.Map;

public interface IWxMainService extends AbstractSerivce {

    /**
     * 处理微信的请求，并组织相应的回复
     * @param
     * @return
     */
    public String responseMsg(String result);

    /**
     * 对微信传过来的参数进行验证安全签名以及解析
     * @param signature
     * @param timestamp
     * @param nonce
     * @param postData
     * @return
     */
    public String checkSignatureAndDecrypt(String signature, String timestamp, String nonce, String postData);

    /**
     * 微信处理第一次回调
     * @param signature
     * @param timestamp
     * @param nonce
     * @param postData
     * @return
     */
    public String firstBack(String signature, String timestamp, String nonce, String postData);

    /**
     * @description 回复文本消息
     * @param activity 活动
     * @return
     */
    public String replyText(WxAssignmentActivity activity, Map<String, String> map);

    /**
     * @description 回复图文消息
     * @param activity
     * @param map
     * @return
     */
    public String replyImageArticle(WxAssignmentActivity activity, Map<String, String> map);

    /**
     * @description 回复模板消息
     * @param activity
     * @param map
     * @return
     */
    public void replyTemplate(WxAssignmentActivity activity, Map<String, String> map);
}
