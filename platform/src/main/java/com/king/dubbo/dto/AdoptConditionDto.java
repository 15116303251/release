package com.king.dubbo.dto;

import java.util.Date;

public class AdoptConditionDto {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column adopt_condition.id
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column adopt_condition.type
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column adopt_condition.catetory
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    private String catetory;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column adopt_condition.personlit
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    private String personlit;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column adopt_condition.wc_habit
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    private String wcHabit;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column adopt_condition.create_time
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    private String createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column adopt_condition.update_time
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    private String updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column adopt_condition.status
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column adopt_condition.can_provide
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    private String canProvide;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column adopt_condition.id
     *
     * @return the value of adopt_condition.id
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column adopt_condition.id
     *
     * @param id the value for adopt_condition.id
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column adopt_condition.type
     *
     * @return the value of adopt_condition.type
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column adopt_condition.type
     *
     * @param type the value for adopt_condition.type
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column adopt_condition.catetory
     *
     * @return the value of adopt_condition.catetory
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    public String getCatetory() {
        return catetory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column adopt_condition.catetory
     *
     * @param catetory the value for adopt_condition.catetory
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    public void setCatetory(String catetory) {
        this.catetory = catetory == null ? null : catetory.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column adopt_condition.personlit
     *
     * @return the value of adopt_condition.personlit
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    public String getPersonlit() {
        return personlit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column adopt_condition.personlit
     *
     * @param personlit the value for adopt_condition.personlit
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    public void setPersonlit(String personlit) {
        this.personlit = personlit == null ? null : personlit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column adopt_condition.wc_habit
     *
     * @return the value of adopt_condition.wc_habit
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    public String getWcHabit() {
        return wcHabit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column adopt_condition.wc_habit
     *
     * @param wcHabit the value for adopt_condition.wc_habit
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    public void setWcHabit(String wcHabit) {
        this.wcHabit = wcHabit == null ? null : wcHabit.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column adopt_condition.status
     *
     * @return the value of adopt_condition.status
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column adopt_condition.status
     *
     * @param status the value for adopt_condition.status
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column adopt_condition.can_provide
     *
     * @return the value of adopt_condition.can_provide
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    public String getCanProvide() {
        return canProvide;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column adopt_condition.can_provide
     *
     * @param canProvide the value for adopt_condition.can_provide
     *
     * @mbg.generated Sat Jun 29 10:07:55 CST 2019
     */
    public void setCanProvide(String canProvide) {
        this.canProvide = canProvide == null ? null : canProvide.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}