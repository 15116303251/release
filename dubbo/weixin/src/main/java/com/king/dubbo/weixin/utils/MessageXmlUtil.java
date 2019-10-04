package com.king.dubbo.weixin.utils;
import com.alibaba.fastjson.JSONObject;
import com.king.dubbo.entities.model.wx.pojo.message.NewArticleMessage;
import com.king.dubbo.entities.model.wx.pojo.message.TextMessage;
import com.king.dubbo.entities.model.wx.pojo.message.item;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import java.io.Writer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MessageXmlUtil {

    private static Logger logger= LogManager.getLogger(MessageXmlUtil.class);

    /**
     * 解析微信发来的请求（XML）
     *
     * @param postData postData
     * @return map 解析结果
     * @throws Exception
     */
    public static Map<String, String> parseXml(String postData) throws Exception {


        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap<String, String>();

        Document document = DocumentHelper.parseText(postData);

        // 得到xml根元素
        Element root = document.getRootElement();

        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();

        // 遍历所有子节点
        for (Element e : elementList) {
            map.put(e.getName(), e.getText());
        }
        logger.info("--解析的postData后的map"+map);

        return map;
    }

    private static  XStream xstream = new XStream(new XppDriver() {

        @Override
        public HierarchicalStreamWriter createWriter(Writer out) {

            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;
                @SuppressWarnings("unchecked")
                public void startNode(String name, Class clazz) {
                    super.startNode(name);
                }

                @Override
                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });

    /**
     * @description 将文本消息转化对应的xml
     * @param testMessage
     * @return
     */
    public static String textMessageToXml(TextMessage testMessage){
        xstream.alias("xml",testMessage.getClass());
        return xstream.toXML(testMessage);
    }

    /**
     * @description 将图文消息转化对应的xml
     * @param newArticleMessage
     * @return
     */
    public static String newsArticleMessageToXml(NewArticleMessage newArticleMessage){
        xstream.alias("xml",newArticleMessage.getClass());
        xstream.alias("item", item.class);
        return xstream.toXML(newArticleMessage);
    }



    public static void main(String args[]){
        try {
         Map<String,String>map=new HashMap<>();
         map.put("first","nihoa");
         map.put("remark","zuohou");
         System.out.println(JSONObject.toJSONString(map));

//            System.out.println(parseXml("<xml><ToUserName><![CDATA[toUser]]></ToUserName>" +
//                    "<FromUserName><![CDATA[fromUser]]></FromUserName>" +
//                    "<CreateTime>1357290913</CreateTime>" +
//                    "<MsgType><![CDATA[voice]]></MsgType>" +
//                    "<MediaId><![CDATA[media_id]]></MediaId>" +
//                    "<Format><![CDATA[Format]]></Format>" +
//                    "<MsgId>1234567890123456</MsgId>" +
//                    "</xml>"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
