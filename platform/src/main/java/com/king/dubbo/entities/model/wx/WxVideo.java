package com.king.dubbo.entities.model.wx;

import java.util.Date;

public class WxVideo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxfwh_reply_video.id
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxfwh_reply_video.title
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxfwh_reply_video.description
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxfwh_reply_video.mediaId
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    private String mediaid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxfwh_reply_video.creat_time
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    private Date creatTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxfwh_reply_video.undate_time
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    private Date undateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wxfwh_reply_video.remark
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxfwh_reply_video.id
     *
     * @return the value of wxfwh_reply_video.id
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxfwh_reply_video.id
     *
     * @param id the value for wxfwh_reply_video.id
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxfwh_reply_video.title
     *
     * @return the value of wxfwh_reply_video.title
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxfwh_reply_video.title
     *
     * @param title the value for wxfwh_reply_video.title
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxfwh_reply_video.description
     *
     * @return the value of wxfwh_reply_video.description
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxfwh_reply_video.description
     *
     * @param description the value for wxfwh_reply_video.description
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxfwh_reply_video.mediaId
     *
     * @return the value of wxfwh_reply_video.mediaId
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public String getMediaid() {
        return mediaid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxfwh_reply_video.mediaId
     *
     * @param mediaid the value for wxfwh_reply_video.mediaId
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public void setMediaid(String mediaid) {
        this.mediaid = mediaid == null ? null : mediaid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxfwh_reply_video.creat_time
     *
     * @return the value of wxfwh_reply_video.creat_time
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public Date getCreatTime() {
        return creatTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxfwh_reply_video.creat_time
     *
     * @param creatTime the value for wxfwh_reply_video.creat_time
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxfwh_reply_video.undate_time
     *
     * @return the value of wxfwh_reply_video.undate_time
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public Date getUndateTime() {
        return undateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxfwh_reply_video.undate_time
     *
     * @param undateTime the value for wxfwh_reply_video.undate_time
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public void setUndateTime(Date undateTime) {
        this.undateTime = undateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wxfwh_reply_video.remark
     *
     * @return the value of wxfwh_reply_video.remark
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wxfwh_reply_video.remark
     *
     * @param remark the value for wxfwh_reply_video.remark
     *
     * @mbggenerated Sun Oct 28 01:23:10 CST 2018
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}