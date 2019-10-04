package com.king.dubbo.entities.model.wx.pojo.menu;

import java.io.Serializable;
import java.util.List;

/**
 * @description 拥有二级子菜单的按钮
 * @author shenwang
 */
public class SecondButton implements Serializable {

    //主菜单的名字
    private String name;

    //二级子菜单的集合
    private List<Object> sub_button;

    public SecondButton(String name, List<Object> sub_button) {
        this.name = name;
        this.sub_button = sub_button;
    }

    public SecondButton() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getSub_button() {
        return sub_button;
    }

    public void setSub_button(List<Object> sub_button) {
        this.sub_button = sub_button;
    }

    @Override
    public String toString() {
        return "SecondButton{" +
                "name='" + name + '\'' +
                ", sub_button=" + sub_button +
                '}';
    }
}
