package com.king.dubbo.weixin.utils;


import com.alibaba.fastjson.JSONObject;
import com.king.dubbo.entities.model.wx.pojo.AccessToken;
import com.king.dubbo.entities.model.wx.pojo.article.ArticleNewForSendToAllUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @description 微信公众号相关的接口的调用
 * @author shenwang
 */
public class WeiXinUtil {

    private static Logger logger= LogManager.getLogger(WeiXinUtil.class);

    /**
     * @description 获取调用接口的accessToken的url(https请求方式: GET)
     */
    private static String getAccessTokenUrl="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    /**
     * @author shenwang
     * @description 根据appid以及appsecret获取accessToken
     * @param appId
     * @param appSecret
     * @return 包含信息的json对象
     */
    public static AccessToken getAccessToken(String appId, String appSecret){
         String reply=httpRequest(WeiXinUtil.getAccessTokenUrl.replace("APPID",appId).replace("APPSECRET",appSecret),"GET",null);
         AccessToken accessToken=null;
         if(reply!=null) {
             JSONObject jsonObject = JSONObject.parseObject(reply);
             accessToken = new AccessToken();
             if(jsonObject.getString("access_token")!=null){
                 accessToken.setAccessToken(jsonObject.getString("access_token"));
                 accessToken.setExpireIn(jsonObject.getIntValue("expires_in"));
             }else {
                 accessToken.setErrCode(jsonObject.getIntValue("errcode"));
                 accessToken.setErrMsg(jsonObject.getString("errmsg"));
             }
         }else{
             logger.info("结果为"+reply);
         }
         return accessToken;
    }

    /**
     * @author shenwang
     * @description 根据url,method,以及传递的参数获取远处返回的内容
     * @param website 请求的website
     * @param method http的请求方式
     * @param content 请求的参数
     * @return url返回的内容
     */
    public static String httpRequest(String website,String method,String content){
        logger.info(website+"---"+method+"---"+content);
        StringBuffer sb=new StringBuffer();
        try {
            URL url=new URL(website);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod(method);
            if(content!=null){
                OutputStream os=connection.getOutputStream();

                os.write(content.getBytes("UTF-8"));
                os.close();
            }
            logger.info("-----"+connection.getResponseCode());
            InputStream inputStream=connection.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

            String line=null;
            if((line=bufferedReader.readLine())!=null){
                sb.append(line);
            }
             logger.info("返回的结果"+sb);
             bufferedReader.close();
             connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }


    public static JSONObject uploadForeverMedia(String url,File file) {

        JSONObject jsonObject =null;
        logger.info("----传入的url---------"+url);
        // 定义数据分隔符
        String boundary = "------------7da2e536604c8";
        try {
            URL uploadUrl = new URL(url);
            HttpURLConnection uploadConn = (HttpURLConnection) uploadUrl
                    .openConnection();
            uploadConn.setDoOutput(true);
            uploadConn.setDoInput(true);
            uploadConn.setRequestMethod("POST");
            // 设置请求头Content-Type
            uploadConn.setRequestProperty("Content-Type",
                    "multipart/form-data;boundary=" + boundary);
            // 获取媒体文件上传的输出流（往微信服务器写数据）
            OutputStream outputStream = uploadConn.getOutputStream();

//            URL mediaUrl = new URL(mediaFileUrl);
//            HttpURLConnection meidaConn = (HttpURLConnection) mediaUrl
//                    .openConnection();
//            meidaConn.setDoOutput(true);
//            meidaConn.setRequestMethod("GET");

            // 从请求头中获取内容类型
            String contentType = "image/jpeg";
            // 根据内容类型判断文件扩展名
            String fileExt = WeiXinUtil.getFileEndWitsh(contentType);
            // 请求体开始
            outputStream.write(("--" + boundary + "\r\n").getBytes());
            outputStream
                    .write(String
                            .format(
                                    "Content-Disposition: form-data; name=\"media\"; filename=\"file1%s\"\r\n",
                                    fileExt).getBytes());
            outputStream.write(String.format("Content-Type: %s\r\n\r\n",
                    contentType).getBytes());

            // 获取媒体文件的输入流（读取文件）
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            byte[] buf = new byte[8096];
            int size = 0;
            while ((size = bis.read(buf)) != -1) {
                // 将媒体文件写到输出流（往微信服务器写数据）
                outputStream.write(buf, 0, size);
            }
            // 请求体结束
            outputStream.write(("\r\n--" + boundary + "--\r\n").getBytes());
            outputStream.close();
            bis.close();


            // 获取媒体文件上传的输入流（从微信服务器读数据）
            InputStream inputStream = uploadConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(
                    inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(
                    inputStreamReader);
            StringBuffer buffer = new StringBuffer();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            inputStream = null;
            uploadConn.disconnect();
            // 使用JSON-lib解析返回结果
            logger.info("返回的结果"+buffer.toString());
            jsonObject=JSONObject.parseObject(buffer.toString());

        } catch (Exception e) {
            String error = String.format("上传媒体文件失败：%s", e);
            logger.info(error);
        }
        return jsonObject;
    }

    /**
     * 根据内容类型判断文件扩展名
     * @param contentType
     *            内容类型
     * @return
     */
    public static String getFileEndWitsh(String contentType) {
        String fileEndWitsh = "";
        if ("image/jpeg".equals(contentType))
            fileEndWitsh = ".jpg";
        else if ("audio/mpeg".equals(contentType))
            fileEndWitsh = ".mp3";
        else if ("audio/amr".equals(contentType))
            fileEndWitsh = ".amr";
        else if ("video/mp4".equals(contentType))
            fileEndWitsh = ".mp4";
        else if ("video/mpeg4".equals(contentType))
            fileEndWitsh = ".mp4";
        return fileEndWitsh;
    }



    /**
     * 生成菜单的url
     */
    public static String menuUrl="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    /**
     * @description 生成菜单
     * @param url
     * @param token
     * @param content
     * @return
     */
    public static JSONObject createMenu(String url,String token,String content){
        String result=httpRequest(url.replace("ACCESS_TOKEN",token),"POST",content);
        JSONObject jsonObject=JSONObject.parseObject(result);
        if(jsonObject.getIntValue("errcode")==0 && "ok".equals(jsonObject.getString("errmsg"))){
            logger.info("微信生成菜单成功");
            return jsonObject;
        }else {
            logger.info("errcode"+jsonObject.getIntValue("errcode")+"---"+"errmsg"+jsonObject.getString("errmsg"));
            return null;
        }
    }

    /**
     * 获取微信公众号所有关注者的openid
     */
    public static String getUserUrl="https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID";

    /**
     * @description 拉取微信关注用户的信息
     * @author shenwang
     * @param url
     * @param token 1
     * @param nextOpenid
     * @return
     */
    public static JSONObject getWxAllUser(String url,String token,String nextOpenid){
        String result =httpRequest(url.replace("ACCESS_TOKEN",token).replace("NEXT_OPENID",nextOpenid),"GET",null);
        JSONObject jsonObject=JSONObject.parseObject(result);
        return jsonObject;
    }

    /**
     * @description 获取微信用户的具体信息的url
     */
    public static String getUserDetailUrl="https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    public static JSONObject getWxUserDetail(String url,String token,String openid){
        String result=httpRequest(url.replace("ACCESS_TOKEN",token).replace("OPENID",openid),"GET",null);
        JSONObject jsonObject=JSONObject.parseObject(result);
        return jsonObject;
    }

    /**
     * @description 上传本地图片的url
     */
    public static String getPictureMediaUrl="https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN";

    /**
     * @description 获取图片上传后的imageUrl
     * @author shenwang
     * @param url
     * @param token
     * @param file
     * @return
     */

    public static String getPictureMedia(String url,String token,File file){
        String imageUrl=uploadForeverMedia(getPictureMediaUrl.replace("ACCESS_TOKEN",token),file).getString("url");
        return imageUrl;
    }
    // http:\/\/mmbiz.qpic.cn\/mmbiz_png\/ar5KJSz7Bth29R6MXDsVOSaiaKXiazRjtIREPLZKImAVfQOOGsOASzcicQZ6icLOqkN49SeZgomaZ7TLc4R4G1hpNg\/0


    //获取图片的mediaId
    public static String getPictureMedia="https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";

    /**
     * 获取图片的mediaId
     * @param accessToken
     * @param type
     * @param file
     * @return
     */
    public static String getPictureMediaId(String accessToken,String type,File file){
        JSONObject json=uploadForeverMedia(getPictureMedia.replace("ACCESS_TOKEN",accessToken).replace("TYPE",type),file);
        System.out.println(json);
        String mediaId=json.getString("media_id");
        return mediaId;
    }


    /**
     * 上传图文消息生成mediaId的链接
     */
    public static String getPictureArticleUrl="https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=ACCESS_TOKEN";

    public static String getPictureArticleMediaId(String accessToken,String url,String content){
        String result = httpRequest(url.replace("ACCESS_TOKEN", accessToken), "POST", content);
        JSONObject jsonObject = JSONObject.parseObject(result);
        if(jsonObject.getString("media_id")!=null){
            return jsonObject.getString("media_id");
        }else{
            logger.info("获取图文的mediaId失败");
            return null;
        }
    }


    //创建标签的url
    public static String createTagUrl="https://api.weixin.qq.com/cgi-bin/tags/create?access_token=ACCESS_TOKEN";

    /**
     * 创建微信用户标签
     * @param accessToken 验证的token
     * @param content 标签的名字
     * @return
     */
    public static JSONObject createTag(String accessToken,String content){
        String result=httpRequest(createTagUrl.replace("ACCESS_TOKEN",accessToken),"POST",content);
        return JSONObject.parseObject(result);
    }

    //为标签添加用户的url
    public static String batchAddTagForUserUrl="https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=ACCESS_TOKEN";

    /**
     *
     * @param accessToken
     * @param content
     * @return
     */
    public static JSONObject batchAddTagForUser(String accessToken,String content){
        String result=httpRequest(batchAddTagForUserUrl.replace("ACCESS_TOKEN",accessToken),"POST",content);
        return JSONObject.parseObject(result);
    }

    /**
     * @description 获取二维码的ticket
     */
    public static String qRCodeTicketUrl="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";




    public static String getSendToTagUserNewArticleContent(ArticleNewForSendToAllUser articleNewForSendToAllUser){
        String content=String.format("{\n" +
                "   \"filter\":{\n" +
                "      \"is_to_all\":%b,\n" +
                "      \"tag_id\":%d\n" +
                "   },\n" +
                "   \"mpnews\":{\n" +
                "      \"media_id\":\"%s\"\n" +
                "   },\n" +
                "    \"msgtype\":\"mpnews\",\n" +
                "    \"send_ignore_reprint\":%d\n" +
                "}",articleNewForSendToAllUser.isToAll(),articleNewForSendToAllUser.getTagId(),articleNewForSendToAllUser.getMediaId(),
                articleNewForSendToAllUser.getSendIgnoreReprint());
        return content;
    }

    public static String sendToAllUserUrl="https://api.weixin.qq.com/cgi-bin/message/mass/sendall?access_token=ACCESS_TOKEN";

    //客服账号添加
    public static String kfAccountAddUrl="https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";

    public static JSONObject addKfAccount(String accessToken,String content){
        String result=WeiXinUtil.httpRequest(kfAccountAddUrl.replace("ACCESS_TOKEN",accessToken),"POST",content);
        return JSONObject.parseObject(result);
    }

    public static void main(String args[]){

//        File file=new File("C:\\Users\\旺\\Pictures\\image\\20150314212812_kCLmy.png");
        //System.out.println(getPictureMedia(getPictureMediaUrl,getAccessToken("wx27c049ab01beff71","ada2055bdda0272c19f0b9135a49ee0d").getAccessToken(),file));
        //System.out.println(getPictureMediaId(getAccessToken("wx27c049ab01beff71","ada2055bdda0272c19f0b9135a49ee0d").getAccessToken(),"thumb",file));
        //CQ2L-Xbn0If8eQe1UrO4DozbUoThie32W7UHROf2now
//        System.out.println(getPictureArticleMediaId(getAccessToken("wx27c049ab01beff71","ada2055bdda0272c19f0b9135a49ee0d").getAccessToken(),getPictureArticleUrl,"{\n" +
//                "\t\"articles\": [{\n" +
//                "\t\t\"thumb_media_id\": \"CQ2L-Xbn0If8eQe1UrO4Dh_TC0sVEA4SR_eEgZBwcXY\",\n" +
//                "\t\t\"author\": \"\",\n" +
//                "\t\t\"only_fans_can_comment\": 0,\n" +
//                "\t\t\"digest\": \"\",\n" +
//                "\t\t\"show_cover_pic\": 0,\n" +
//                "\t\t\"content_source_url\": \"\",\n" +
//                "\t\t\"need_open_comment\": 0,\n" +
//                "\t\t\"title\": \"测试图文消息\",\n" +
//                "\t\t\"content\": \"小红帽\"\n" +
//                "\t}]\n" +
//                "}"));


//        ArticleNewForSendToAllUser articleNewForSendToAllUser=new ArticleNewForSendToAllUser();
//        articleNewForSendToAllUser.setToAll(false);
//        articleNewForSendToAllUser.setTagId(2);
//        articleNewForSendToAllUser.setMediaId("123");
//        articleNewForSendToAllUser.setSendIgnoreReprint(0);
//        articleNewForSendToAllUser.setType("mpnews");
//        System.out.println(getSendToTagUserNewArticleContent(articleNewForSendToAllUser));

//   112  System.out.println(createTag(getAccessToken("wx27c049ab01beff71","ada2055bdda0272c19f0b9135a49ee0d").getAccessToken(),"{   \"tag\" : {     \"name\" : \"失落的人\"//标签名   } }"));



//          System.out.println(batchAddTagForUser(getAccessToken("wx27c049ab01beff71","ada2055bdda0272c19f0b9135a49ee0d").getAccessToken(),"{\n" +
//                  "\t\"openid_list\": [ //粉丝列表    \n" +
//                  "\t\t\"osh-W0cplSTKP_bavD7gsLe9tuLo\",\n" +
//                  "\t],\n" +
//                  "\t\"tagid\": 112\n" +
//                  "}"));


//        System.out.println(httpRequest(qRCodeTicketUrl.replace("TOKEN",getAccessToken("wx27c049ab01beff71","ada2055bdda0272c19f0b9135a49ee0d").getAccessToken()),"POST","{\"expire_seconds\": 604800, \"action_name\": \"QR_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"test\"}}}"));
        //{"ticket":"gQHj7zwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAydE9ZLTlLT3ZlbWgxNklEUk5zY2wAAgQsLSxcAwSAOgkA","expire_seconds":604800,"url":"http:\/\/weixin.qq.com\/q\/02tOY-9KOvemh16IDRNscl"}
         String content="{\n" +
                 "     \"kf_account\" : \"test1@test\",\n" +
                 "     \"nickname\" : \"客服1\",\n" +
                 "     \"password\" : \"pswmd5\"\n" +
                 "}";

         System.out.println(WeiXinUtil.addKfAccount(getAccessToken("wx27c049ab01beff71","ada2055bdda0272c19f0b9135a49ee0d").getAccessToken(),content));
    }
    //24_qR3xd4ZVZtxTkCmNOjKDlBl5FJoifOcJZFKeaKbfyeX5FzxxQCJB-ghfQp5FtsIsFD1KEUMdzWyAkT6PNV4tc0T_kVqPLNV2jcD43qJZGw2vVb7itwouJhhRIoL6UZ2tRj2nWfLEr1UKISSLXFGcAGAGOP
}
