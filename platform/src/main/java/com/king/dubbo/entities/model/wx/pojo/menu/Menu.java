package com.king.dubbo.entities.model.wx.pojo.menu;

import java.io.Serializable;
import java.util.List;

/**
 * @description 菜单栏的整体
 * @author shenwang
 */
public class Menu implements Serializable {

    //展示在用户面前的按钮
    private List<Object> button;

    public Menu(List<Object> button) {
        this.button = button;
    }

    public Menu() {
    }

    public List<Object> getButton() {
        return button;
    }

    public void setButton(List<Object> button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "button=" + button +
                '}';
    }
}
