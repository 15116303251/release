package com.king.dubbo.weixin.bo;


import com.alibaba.fastjson.JSONObject;
import com.king.dubbo.entities.model.wx.WxMenuConfig;

import java.util.List;
import java.util.Map;

/**
 * @description 菜单的服务层与数据库层的中间层
 * @author shenwang
 */
public interface IWxMenuBo extends IAbstractBo{

    /**
     * @author shenwang
     * @description 获取接口调用的accessToken
     * @return
     */
    public String getAccessToken();

    /**
     * @description 查询菜单
     * @param state 菜单的状态
     * @param level 菜单的级别
     * @param parentId 菜单的父级id
     * @return
     */
    public List<WxMenuConfig> selectAll(String state, Integer level, Integer parentId);

    /**
     * 生成菜单的json字符串
     * @param list 一级按钮的集合
     * @return
     */
    public String getMenuJson(List<WxMenuConfig> list);

    /**
     * 创建菜单
     * @param state 菜单的状态
     * @param level 菜单的级别
     * @param parentId 菜单的父级id
     * @return
     */
    public JSONObject createMenu(String state, Integer level, Integer parentId);

    /**
     * @description 加载微信请求的消息类型
     */
    public Map<String,String> loadWxRequestMsgType();

    /**
     * @description 更新接口调用的access_token
     */
    public void updateAccessToken();
}
