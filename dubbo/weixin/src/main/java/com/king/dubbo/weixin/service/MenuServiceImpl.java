package com.king.dubbo.weixin.service;


import com.king.dubbo.service.weixin.IWxMenuService;
import com.king.dubbo.weixin.bo.IWxMenuBo;
import com.king.dubbo.entities.model.wx.WxMenuConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author  shenwang
 * @description 菜单相关接口的实现类
 */
@Service("wxMenuService")
public class MenuServiceImpl implements IWxMenuService {

    @Autowired
    IWxMenuBo wxMenuBo;

    @Override
    public Integer insertOne(Object object) {
        return wxMenuBo.insertOne(object);
    }

    @Override
    public Object selectOne(Integer id) {
        WxMenuConfig wxMenuConfig= (WxMenuConfig) wxMenuBo.selectOne(id);
        return wxMenuConfig;
    }

    @Override
    public Integer updateOne(Object object) {
        Integer status=wxMenuBo.updateOne(object);
        return status;
    }

    @Override
    public Integer deleteOne(Integer id) {
        Integer status=wxMenuBo.deleteOne(id);
        return status;
    }

    @Override
    public void createMenu(String state, Integer level, Integer parentId) {
        wxMenuBo.createMenu(state,level,parentId);
    }

    @Override
    public void updateAccessToken() {
        wxMenuBo.updateAccessToken();
    }
}
