package com.king.dubbo.entities.model.wx.pojo.message;

import java.util.ArrayList;
import java.util.List;

public class TemplateMessage {

    private String touser;

    private String template_id;

    private String url;

    private String topColor;

    private List<TemplateParam> templateParamList;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTopColor() {
        return topColor;
    }

    public void setTopColor(String topColor) {
        this.topColor = topColor;
    }

    public List<TemplateParam> getTemplateParamList() {
        return templateParamList;
    }

    public void setTemplateParamList(List<TemplateParam> templateParamList) {
        this.templateParamList = templateParamList;
    }

    public String toJson(){
        StringBuffer sb=new StringBuffer();
        sb.append("{");
        sb.append(String.format("\"touser\":\"%s\"", this.touser)).append(",");
        sb.append(String.format("\"template_id\":\"%s\"", this.template_id)).append(",");
        sb.append(String.format("\"url\":\"%s\"", this.url)).append(",");
        sb.append(String.format("\"topcolor\":\"%s\"", this.topColor)).append(",");
        sb.append("\"data\":{");

        TemplateParam param = null;

        for(int i=0;i<templateParamList.size();i++){
            param=templateParamList.get(i);
            if (i < this.templateParamList.size() - 1){
                sb.append(String.format("\"%s\": {\"value\":\"%s\",\"color\":\"%s\"},", param.getName(), param.getValue(), param.getColor()));
            }else{
                sb.append(String.format("\"%s\": {\"value\":\"%s\",\"color\":\"%s\"}", param.getName(), param.getValue(), param.getColor()));
            }
        }
        sb.append("}");
        sb.append("}");
        return sb.toString();
    }

    public static void main(String args[]){

        List<TemplateParam>list=new ArrayList<TemplateParam>();
        list.add(new TemplateParam("first","圣诞开始","#173177"));
        list.add(new TemplateParam("time","2018-08-12","#173177"));
        list.add(new TemplateParam("number","12","#173177"));
        list.add(new TemplateParam("remark","圣诞结束","#173177"));
        TemplateMessage templateMessage =new TemplateMessage();
        templateMessage.setTemplateParamList(list);
        System.out.println(templateMessage.toJson());

    }
}
