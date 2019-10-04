package com.king.dubbo.weixin.bo.impl;

import com.alibaba.fastjson.JSONObject;
import com.king.dubbo.annoation.RedisCache;
import com.king.dubbo.annoation.RedisCacheEvict;
import com.king.dubbo.constant.WxParamConstant;
import com.king.dubbo.redis.config.RedisHelper;
import com.king.dubbo.redis.config.ScopeConstant;
import com.king.dubbo.weixin.bo.IWxMenuBo;
import com.king.dubbo.weixin.dao.WxMenuConfigMapper;
import com.king.dubbo.entities.model.wx.WxMenuConfig;
import com.king.dubbo.entities.model.wx.WxMenuConfigExample;
import com.king.dubbo.entities.model.wx.pojo.AccessToken;
import com.king.dubbo.entities.model.wx.pojo.menu.ClickButton;
import com.king.dubbo.entities.model.wx.pojo.menu.Menu;
import com.king.dubbo.entities.model.wx.pojo.menu.SecondButton;
import com.king.dubbo.entities.model.wx.pojo.menu.ViewButton;
import com.king.dubbo.weixin.utils.BackFrontResult;
import com.king.dubbo.weixin.utils.DateUtils;
import com.king.dubbo.weixin.utils.WeiXinUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @description 服务层与数据库访问层的中间层
 * @author shenwang
 */
@Component
public class WxMenuBoImpl implements IWxMenuBo {

    public static Map<String,String> map=new HashMap<>();

    @Autowired
    WxMenuConfigMapper menuConfigMapper;

    @Autowired
    RedisHelper redisHelper;

    @Override
    public Integer insertOne(Object object) {
        BackFrontResult result=new BackFrontResult();
        Integer status =menuConfigMapper.insertSelective((WxMenuConfig) object);
        return status;
    }

    @Override
    @RedisCache(key = ScopeConstant.WX_MENU ,fieldKey = "#id",expireTime =30,timeUnit = TimeUnit.MINUTES)
    public Object selectOne(Integer id) {
        WxMenuConfig wxMenuConfig=menuConfigMapper.selectByPrimaryKey(id);
        return wxMenuConfig;
    }

    @Override
    public Integer updateOne(Object object) {
        Integer status=menuConfigMapper.updateByPrimaryKey((WxMenuConfig) object);
        return status;
    }

    @Override
    @RedisCacheEvict(key = ScopeConstant.WX_MENU ,fieldKey = "#id")
    public Integer deleteOne(Integer id) {
        Integer status=menuConfigMapper.deleteByPrimaryKey(id);
        if(status==1){
            logger.info("删除数据库中此条记录成功");
        }else{
            logger.info("删除数据库中此条记录失败");
        }
        return status;
    }

    @Override
    public String getAccessToken() {

        Object o1 =redisHelper.getObjectValue(WxParamConstant.WX_APPID);
        Object o2 =redisHelper.getObjectValue(WxParamConstant.WX_APPSECRET);
        Object o3=redisHelper.getObjectValue(WxParamConstant.WX_INTEFER_TOKEN_TIME);

        String appId=o1!=null?(String)o1:null;
        String appSecret=o2!=null?(String)o2:null;

        if(o3!=null){
            long lastTime= DateUtils.tranferStringToDate((String) o3).getTime();
            long currentTime= DateUtils.getCurrentDate().getTime();
            if(currentTime-lastTime>2*60*60*1000){
                AccessToken accessToken= WeiXinUtil.getAccessToken(appId,appSecret);
                if(accessToken.getAccessToken()!=null){
                    redisHelper.putObjectValue(WxParamConstant.WX_INTEFER_TOKEN,accessToken.getAccessToken());
                    redisHelper.putObjectValue(WxParamConstant.WX_INTEFER_TOKEN_TIME,DateUtils.tranferDateToString(DateUtils.getCurrentDate()));
                }
            }
        }
        Object o4=redisHelper.getObjectValue(WxParamConstant.WX_INTEFER_TOKEN);
        return o4!=null?(String)o4:null;
    }

    @Override
    public List<WxMenuConfig> selectAll(String state, Integer level, Integer parentId) {
        WxMenuConfigExample example=new WxMenuConfigExample();
        WxMenuConfigExample.Criteria criteria=example.createCriteria();

        if(state!=null){
            criteria.andStateEqualTo(state);
        }
        if(level!=null){
            criteria.andLevelEqualTo(level);
        }
        if(parentId!=null){
            criteria.andParentIdEqualTo(parentId);
        }
         List<WxMenuConfig> list=menuConfigMapper.selectByExample(example);
        return list;
    }

    @Override
    public String getMenuJson(List<WxMenuConfig> list) {
        Menu menu=new Menu();
        WxMenuConfig wxMenuConfig=null;
        List<Object> menulist=new ArrayList<>();

        if(list==null || list.size()==0 ||list.size()>3){
            logger.info("一级菜单不能为空||一级菜单的个数不能超过3个");
            return null;
        }

        for(int i=0;i<list.size();i++){
            wxMenuConfig=list.get(i);
            //根据以及菜单的内容进行判断是否有二级子菜单
            if(wxMenuConfig.getContent()!=null){
                if(wxMenuConfig.getType().equals("CLICK")){
                    ClickButton clickButton=new ClickButton(wxMenuConfig.getType().toLowerCase(),wxMenuConfig.getName(),wxMenuConfig.getContent());
                    menulist.add(clickButton);
                }else {
                    ViewButton viewButton=new ViewButton(wxMenuConfig.getType().toLowerCase(), wxMenuConfig.getName(),wxMenuConfig.getContent());
                    menulist.add(viewButton);
                }

            }else{
                SecondButton secondButton=new SecondButton();
                 List<Object> secondList=new ArrayList<>();
                 List<WxMenuConfig>wxMenuConfigs= selectAll("ENABLE",null,wxMenuConfig.getId());

                 if(wxMenuConfigs==null ||wxMenuConfigs.size()==0||wxMenuConfigs.size()>5){
                     logger.info("一级菜单的二级菜单不能为空 || 二级菜单的数量不能超过5");
                 }

                 for(int j=0;j<wxMenuConfigs.size();j++){
                     WxMenuConfig w=wxMenuConfigs.get(j);
                     //只支持小写的值，大写的值的会导致utf-8，65318 报错
                     if(w.getType().equals("click")){
                         ClickButton clickButton=new ClickButton(w.getType().toLowerCase(),w.getName(),w.getContent());
                         secondList.add(clickButton);
                     }else {
                         ViewButton viewButton=new ViewButton(w.getType().toLowerCase(), w.getName(),w.getContent());
                         secondList.add(viewButton);
                     }

                 }
                 secondButton.setSub_button(secondList);
                 secondButton.setName(wxMenuConfig.getName());
                 menulist.add(secondButton);
            }
        }
        menu.setButton(menulist);
        String menuJson= JSONObject.toJSONString(menu);
        return menuJson;
    }

    @Override
    public JSONObject createMenu(String state, Integer level, Integer parentId) {

        List<WxMenuConfig> list=selectAll(state,level,parentId);
        String menuJson=getMenuJson(list);
        logger.info("组装的json为"+menuJson);
        JSONObject json=WeiXinUtil.createMenu(WeiXinUtil.menuUrl,getAccessToken(),menuJson);
        return json;
    }


    public Map<String,String> loadWxRequestMsgType(){

        if(map.isEmpty()){
            String msgType= (String) redisHelper.getObjectValue(WxParamConstant.WX_MSG_TYPE_CONTENT);
            String[] msgArr=msgType.split(",");
            for (String items:msgArr) {
                String []item= items.split("_");
                map.put(item[0], item[1]);
                if(item.length==3) {
                    map.put(item[1], item[2]);
                }
            }
        }
        logger.info("加载微信的请求消息类型结束");
        return map;
    }

    @Override
    public void updateAccessToken() {
        Object o1 =redisHelper.getObjectValue(WxParamConstant.WX_APPID);
        Object o2 =redisHelper.getObjectValue(WxParamConstant.WX_APPSECRET);

        String appId=o1!=null?(String)o1:null;
        String appSecret=o2!=null?(String)o2:null;

        AccessToken accessToken= WeiXinUtil.getAccessToken(appId,appSecret);
        if(accessToken.getAccessToken()!=null){
            redisHelper.putObjectValue(WxParamConstant.WX_INTEFER_TOKEN,accessToken.getAccessToken());
            redisHelper.putObjectValue(WxParamConstant.WX_INTEFER_TOKEN_TIME,DateUtils.tranferDateToString(DateUtils.getCurrentDate()));
        }
    }

}
