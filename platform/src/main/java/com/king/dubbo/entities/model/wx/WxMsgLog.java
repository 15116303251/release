package com.king.dubbo.entities.model.wx;

import java.util.Date;

public class WxMsgLog {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxfwh_msg_log.id
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxfwh_msg_log.userId
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    private Integer userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxfwh_msg_log.temKey
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    private String temkey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxfwh_msg_log.errorCode
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    private Integer errorcode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxfwh_msg_log.sendTime
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    private Date sendtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxfwh_msg_log.type
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxfwh_msg_log.content
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxfwh_msg_log.id
     *
     * @return the value of wxfwh_msg_log.id
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxfwh_msg_log.id
     *
     * @param id the value for wxfwh_msg_log.id
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxfwh_msg_log.userId
     *
     * @return the value of wxfwh_msg_log.userId
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxfwh_msg_log.userId
     *
     * @param userid the value for wxfwh_msg_log.userId
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxfwh_msg_log.temKey
     *
     * @return the value of wxfwh_msg_log.temKey
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public String getTemkey() {
        return temkey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxfwh_msg_log.temKey
     *
     * @param temkey the value for wxfwh_msg_log.temKey
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public void setTemkey(String temkey) {
        this.temkey = temkey == null ? null : temkey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxfwh_msg_log.errorCode
     *
     * @return the value of wxfwh_msg_log.errorCode
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public Integer getErrorcode() {
        return errorcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxfwh_msg_log.errorCode
     *
     * @param errorcode the value for wxfwh_msg_log.errorCode
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public void setErrorcode(Integer errorcode) {
        this.errorcode = errorcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxfwh_msg_log.sendTime
     *
     * @return the value of wxfwh_msg_log.sendTime
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public Date getSendtime() {
        return sendtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxfwh_msg_log.sendTime
     *
     * @param sendtime the value for wxfwh_msg_log.sendTime
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxfwh_msg_log.type
     *
     * @return the value of wxfwh_msg_log.type
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxfwh_msg_log.type
     *
     * @param type the value for wxfwh_msg_log.type
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxfwh_msg_log.content
     *
     * @return the value of wxfwh_msg_log.content
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxfwh_msg_log.content
     *
     * @param content the value for wxfwh_msg_log.content
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}