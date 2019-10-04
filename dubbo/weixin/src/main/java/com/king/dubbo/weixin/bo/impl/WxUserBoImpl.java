package com.king.dubbo.weixin.bo.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.king.dubbo.weixin.bo.IWxUserBo;
import com.king.dubbo.weixin.dao.WxUserInfoMapper;
import com.king.dubbo.entities.model.wx.WxUserInfo;
import com.king.dubbo.weixin.utils.DateUtils;
import com.king.dubbo.weixin.utils.WeiXinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description 微信用户相关操作的中间类
 * @author shenwang
 */
@Component
public class WxUserBoImpl implements IWxUserBo {

    @Autowired
    WxUserInfoMapper wxUserInfoMapper;

    @Override
    public Integer insertOne(Object object) {
        WxUserInfo wxUserInfo= (WxUserInfo) object;
        int status=wxUserInfoMapper.insertSelective(wxUserInfo);
        return status;
    }

    @Override
    public Object selectOne(Integer id) {
        WxUserInfo wxUserInfo=wxUserInfoMapper.selectByPrimaryKey(id);
        return wxUserInfo;
    }

    @Override
    public Integer updateOne(Object object) {
        WxUserInfo wxUserInfo= (WxUserInfo) object;
        int status=wxUserInfoMapper.updateByPrimaryKeySelective(wxUserInfo);
        return status;
    }

    @Override
    public Integer deleteOne(Integer id) {
        return null;
    }

    @Override
    public void getWxAllUser(String token, String nextOpenid) {
        JSONObject jsonObject= WeiXinUtil.getWxAllUser(WeiXinUtil.getUserUrl,token,nextOpenid);
        while(jsonObject.getIntValue("count")>0){
            JSONObject dataObject=jsonObject.getJSONObject("data");
            JSONArray jsonArray=dataObject.getJSONArray("openid");
            if(jsonArray!=null){
                for(int i=0;i<jsonArray.size();i++){
                    String openid= (String) jsonArray.get(i);
                    //根据openid获取微信用户的具体信息
                    WxUserInfo wxUserInfo=new WxUserInfo();
                    JSONObject wxUserDetail = WeiXinUtil.getWxUserDetail(WeiXinUtil.getUserDetailUrl, token, openid);
                    try {
                        wxUserInfo.setOpenid(wxUserDetail.getString("openid"));
                        wxUserInfo.setCity(wxUserDetail.getString("city"));
                        wxUserInfo.setCountry(wxUserDetail.getString("country"));
                        wxUserInfo.setCreatetime(DateUtils.getCurrentDate());
                        wxUserInfo.setNickname(wxUserDetail.getString("nickname"));
                        wxUserInfo.setSex(wxUserDetail.getString("sex"));
                    }catch(Exception e){
                        logger.info("获取微信用户具体信息失败"+wxUserDetail.getIntValue("errcode")+wxUserDetail.getString("errmsg"));
                    }
                    //根据openid去数据库查询用户的信息，若存在就更新数据的记录，不存在的话，就插入该条记录
                    WxUserInfo wxUser=wxUserInfoMapper.getWxUserByOpenId(openid);
                    wxUserInfo.setId(wxUser.getId());
                    if(wxUser==null){
                        insertOne(wxUserInfo);
                    }else{
                        updateOne(wxUserInfo);
                    }
                }
            }
           jsonObject= WeiXinUtil.getWxAllUser(WeiXinUtil.getUserUrl,token,jsonObject.getString("next_openid"));
        }
    }

    @Override
    public WxUserInfo getWxUserByOpenId(String openid) {
        return wxUserInfoMapper.getWxUserByOpenId(openid);
    }
}
