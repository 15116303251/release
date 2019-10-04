package com.king.dubbo.entities.model;

/**
 * @description 可配置的常量
 * @author shenwang
 */
public class Constrant {

    /**
     * 常量名
     */
    private String key;

    /**
     * 内容
     */
    private String content;

    /**
     * 描述
     */
    private String description;

    /**
     * 类型
     */
    private String type;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String
    toString() {
        return "Constrant{" +
                "key='" + key + '\'' +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
