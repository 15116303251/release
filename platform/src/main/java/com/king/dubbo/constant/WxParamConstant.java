package com.king.dubbo.constant;

/**
 * @description 微信相关常量的配置、
 * @author shenwang
 */
public interface WxParamConstant {

    /**
     * 微信的密钥id
     */
    String WX_APPID="WX.APPID";

    /**
     * 微信密钥密码secret
     */
    String WX_APPSECRET="WX.APPSECRET";

    /**
     * 微信的接口调用的token生成的时间
     */
    String WX_INTEFER_TOKEN_TIME="WX.INTEFER_TOKEN_TIME";

    /**
     * 微信的接口调用的token
     */
    String WX_INTEFER_TOKEN="WX.INTEFER_TOKEN";

    /**
     * 微信后台配置的token
     */
    String WX_TOKEN="WX.TOKEN";

    /**
     * 微信后台配置的密钥
     */
    String WX_ENCODING_AES_KEY="WX.ENCODING_AES_KEY";

    /**
     * 微信信息是否加密
     */
    String WX_ENCRYPT_FLAG="WX.WX_ENCRYPT_FLAG";

    /**
     * 微信请求消息中的消息类型
     */
    String WX_MSG_TYPE_CONTENT="WX.MSG_TYPE_CONTENT";
}
