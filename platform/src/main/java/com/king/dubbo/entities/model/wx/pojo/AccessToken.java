package com.king.dubbo.entities.model.wx.pojo;

/**
 * @descripton accesstoken的实体类,供其它服务调用
 * @author shenwang
 */
public class AccessToken {

    private String accessToken;

    private Integer expireIn;

    private Integer errCode;

    private String errMsg;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(Integer expireIn) {
        this.expireIn = expireIn;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "accessToken='" + accessToken + '\'' +
                ", expireIn=" + expireIn +
                ", errCode=" + errCode +
                ", errMsg='" + errMsg + '\'' +
                '}';
    }
}
