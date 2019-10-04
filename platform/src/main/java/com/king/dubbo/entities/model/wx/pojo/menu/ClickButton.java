package com.king.dubbo.entities.model.wx.pojo.menu;

import java.io.Serializable;

/**
 * @description click按钮
 * @author shenwang
 */
public class ClickButton implements Serializable {

    //click按钮的类型
    private String type;
    //click按钮的名字
    private String name;
    //click按钮的key
    private String key;

    public ClickButton(String type, String name, String key) {
        this.type = type;
        this.name = name;
        this.key = key;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "ClickButton{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
