package com.king.dubbo.entities.model.wx.pojo.menu;

import java.io.Serializable;

/**
 * @description 带链接的按钮
 * @author shenwang
 */
public class ViewButton implements Serializable {

    //按钮的类型
    private String type;
    //按钮的名字
    private String name;
    //按钮的链接
    private String url;

    public ViewButton(String type, String name, String url) {
        this.type = type;
        this.name = name;
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ViewButton{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
