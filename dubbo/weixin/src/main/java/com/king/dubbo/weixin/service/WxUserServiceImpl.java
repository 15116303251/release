package com.king.dubbo.weixin.service;


import com.king.dubbo.service.weixin.IWxUserService;
import com.king.dubbo.weixin.bo.IWxMenuBo;
import com.king.dubbo.weixin.bo.IWxUserBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("wxUserService")
public class WxUserServiceImpl implements IWxUserService {

    @Autowired
    IWxUserBo wxUserBo;
    @Autowired
    IWxMenuBo menuBo;

    @Override
    public void gainWxAllUser() {
        logger.info("从微信端获取用户插入到数据库开始");
        wxUserBo.getWxAllUser(menuBo.getAccessToken(),"");
        logger.info("从微信端获取用户插入到数据库结束");
    }

    @Override
    public Integer insertOne(Object object) {
        return null;
    }

    @Override
    public Object selectOne(Integer id) {
        return null;
    }

    @Override
    public Integer updateOne(Object object) {
        return null;
    }

    @Override
    public Integer deleteOne(Integer id) {
        return null;
    }
}
