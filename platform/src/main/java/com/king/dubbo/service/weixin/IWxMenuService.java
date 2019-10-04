package com.king.dubbo.service.weixin;

/**
 * @author shenwang
 * @description 微信菜单的相关操作
 */
public interface IWxMenuService extends AbstractSerivce{


    public void createMenu(String state, Integer level, Integer parentId);

    /**
     * @description 更新接口调用的access_token
     */
    public void updateAccessToken();
}
