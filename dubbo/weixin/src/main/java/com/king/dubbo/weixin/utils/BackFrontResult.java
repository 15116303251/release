package com.king.dubbo.weixin.utils;

import java.io.Serializable;

/**
 * @author shenwang
 * @description 返回前端的统一实体
 */
public class BackFrontResult implements Serializable {

    /**
     * 错误码
     */
    private String errcode="0";
    /**
     * 错误消息
     */
    private String errmsg="success";
    /**
     * 返回的数据
     */
    private Object data="";

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
