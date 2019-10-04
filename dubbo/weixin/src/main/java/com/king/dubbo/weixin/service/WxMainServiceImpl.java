package com.king.dubbo.weixin.service;

import com.king.dubbo.constant.WxParamConstant;
import com.king.dubbo.entities.model.wx.*;
import com.king.dubbo.entities.model.wx.pojo.message.*;
import com.king.dubbo.redis.config.RedisHelper;
import com.king.dubbo.service.weixin.IWxMainService;
import com.king.dubbo.weixin.bo.*;
import com.king.dubbo.weixin.utils.MessageXmlUtil;
import com.king.dubbo.weixin.utils.WeiXinUtil;
import com.king.dubbo.weixin.validate.AesException;
import com.king.dubbo.weixin.validate.WXBizMsgCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("wxMainService")
public class WxMainServiceImpl implements IWxMainService {

    @Autowired
    RedisHelper redisHelper;
    @Autowired
    IWxMenuBo wxMenuBo;
    @Autowired
    IWxReplyTextBo wxReplyTextBo;
    @Autowired
    IWxNewArticleInfoBo wxNewArticleInfoBo;
    @Autowired
    IWxActivityAssignmentBo wxActivityAssignmentBo;
    @Autowired
    IWxTemplateBo wxTemplateBo;


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


    @Override
    public String checkSignatureAndDecrypt(String signature, String timestamp, String nonce, String postData) {
        try {
            String result=null;
            boolean flag=Boolean.parseBoolean((String)(redisHelper.getObjectValue(WxParamConstant.WX_ENCRYPT_FLAG)));
            WXBizMsgCrypt wxBizMsgCrypt=new WXBizMsgCrypt((String)(redisHelper.getObjectValue(WxParamConstant.WX_TOKEN)),(String)(redisHelper.getObjectValue(WxParamConstant.WX_ENCODING_AES_KEY)),(String)(redisHelper.getObjectValue(WxParamConstant.WX_APPID)));

            //判断请求中的参数是否需要解密
            if(flag){
                result=wxBizMsgCrypt.decryptMsg(signature,timestamp,nonce,postData);
            }else{
                result=postData;
            }

            //判断返回的数据是否需要加密
            if(result!=null){
                String responseMsg=responseMsg(result);
                if(flag){
                    responseMsg=wxBizMsgCrypt.encryptMsg(responseMsg,timestamp,nonce);
                }
               return responseMsg;
            }else{
                return "fail";
            }
        } catch (AesException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String firstBack(String signature, String timestamp, String nonce, String echoStr) {

        WXBizMsgCrypt wxBizMsgCrypt= null;
        String result="fail";
        try {
            wxBizMsgCrypt = new WXBizMsgCrypt((String)(redisHelper.getObjectValue(WxParamConstant.WX_TOKEN)),(String)(redisHelper.getObjectValue(WxParamConstant.WX_ENCODING_AES_KEY)),(String)(redisHelper.getObjectValue(WxParamConstant.WX_APPID)));
            result=wxBizMsgCrypt.verifyUrlWxSignature(signature,(String)(redisHelper.getObjectValue(WxParamConstant.WX_TOKEN)),timestamp,nonce,echoStr);
        } catch (AesException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String responseMsg(String result) {

        //Map<String,String>msgTypeMap=wxMenuBo.loadWxRequestMsgType();
        String reponseMsg=null;

        try {
            //解析请求中的参数到map
            Map<String,String> map= MessageXmlUtil.parseXml(result);
            String msgType=map.get("MsgType");

            //根据请求的msg_type类型进行相应的操作
            if("event".equals(msgType)){
                String eventType=map.get("Event");

                if(map.get("Ticket") != null){//扫描带参数二维码事件

                }else if(map.get("EventKey") != null){//自定义菜单事件
                    reponseMsg=productResponseMsg(map,eventType,map.get("EventKey"));

                }else if(eventType != null){
                    if("LOCATION".equals(eventType)){//处理地理位置

                    }else{//处理第一次关注
                        reponseMsg=productResponseMsg(map,eventType,null);

                    }
                }

            }else{

                String content=map.get("Content");
                //String msgTypeValue=map.get(msgTypeMap.get(msgType));
                reponseMsg= productResponseMsg(map,msgType,content);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reponseMsg;
    }

    @Override
    public String replyText(WxAssignmentActivity activity, Map<String,String>map) {

        if( activity.getRelationId()==null){
            logger.info("回复文本消息的相关参数不全"+activity.getRelationId());
        }

        WxTextWithBLOBs wxText= (WxTextWithBLOBs) wxReplyTextBo.selectOne(activity.getRelationId());

        TextMessage textMessage=new TextMessage();
        textMessage.setToUserName(map.get("FromUserName"));
        textMessage.setFromUserName(map.get("ToUserName"));
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setMsgId(new Date().getTime());
        textMessage.setContent(wxText.getUnbindUnfreeloginText());
        textMessage.setMsgType(activity.getReplyType().toLowerCase());

        String responseMsg=MessageXmlUtil.textMessageToXml(textMessage);

        return responseMsg;
    }

    @Override
    public String replyImageArticle(WxAssignmentActivity activity,Map<String,String>map) {

        if( activity.getRelationId()==null){
            logger.info("回复图文消息的相关参数不全"+activity.getRelationId());
        }

        WxNews wxNews= wxNewArticleInfoBo.getWxNewsByPrimaryKey(activity.getRelationId());
        NewArticleMessage newArticleMessage=wxNewArticleInfoBo.getHandleDealNewsArticle(wxNews.getCode());
        newArticleMessage= (NewArticleMessage) productMessage(activity,map,newArticleMessage);
        String responseMsg=MessageXmlUtil.newsArticleMessageToXml(newArticleMessage);
        return responseMsg;
    }

    @Override
    public void replyTemplate(WxAssignmentActivity activity,Map<String,String>map) {

        if( activity.getRelationId()==null){
            logger.info("回复模板消息的相关参数不全"+activity.getRelationId());
        }
        WxReplyTemplateInfo wxReplyTemplateInfo=wxTemplateBo.getWxTemplateInfoById(activity.getRelationId());
        WxTemplateInfo wxTemplateInfo=wxTemplateBo.getTemplateInfoByTemKey(wxReplyTemplateInfo.getUnbindTemplateKey());

        List<TemplateParam> list=new ArrayList<>();
        list.add(new TemplateParam("first","圣诞开始","#173177"));
        list.add(new TemplateParam("time","2018-08-12","#173177"));
        list.add(new TemplateParam("number","12","#173177"));
        list.add(new TemplateParam("remark","圣诞结束","#173177"));

        TemplateMessage templateMessage=new TemplateMessage();
        templateMessage.setTemplate_id(wxTemplateInfo.getTemplateid());
        templateMessage.setUrl(wxTemplateInfo.getUrl());
        templateMessage.setTouser(map.get("FromUserName"));
        templateMessage.setTemplateParamList(list);
        String responseMsg=templateMessage.toJson();

        WeiXinUtil.httpRequest("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN",wxMenuBo.getAccessToken()),"POST",responseMsg);
    }


    /**
     * @description 组装消息的实体类
     * @param activity
     * @param map
     * @param baseMessage
     * @return
     */
    public BaseMessage productMessage(WxAssignmentActivity activity, Map<String,String>map, BaseMessage baseMessage){
        baseMessage.setToUserName(map.get("FromUserName"));
        baseMessage.setFromUserName(map.get("ToUserName"));
        baseMessage.setCreateTime(new Date().getTime());
        baseMessage.setMsgType(activity.getReplyType().toLowerCase());
        return baseMessage;
    }

    public String productResponseMsg(Map<String,String>map,String eventType,String content){

        String reponseMsg=null;

        WxAssignmentActivity activity=wxActivityAssignmentBo.queryWxAssignmentActivityByTypeAndContent(eventType,content);
        String replyType= activity.getReplyType();

        if(activity!=null && replyType!=null){
            if("TEXT".equals(replyType)){
                reponseMsg=replyText(activity,map);
            }else if("NEWS".equals(replyType)){
                reponseMsg=replyImageArticle(activity,map);
            }else if("TEMPLATE".equals(replyType)){
                replyTemplate(activity,map);
                reponseMsg="";
            }else if("NOREPLY".equals(replyType)){
                reponseMsg="";
            }

        }else{
            logger.info("活动相关的参数不全"+activity.getActivityName());
        }
        return reponseMsg;
    }
}
