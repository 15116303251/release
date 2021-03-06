package com.king.dubbo.animal.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnimalHabitExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table habit
     *
     * @mbg.generated Thu Jun 27 22:40:32 CST 2019
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table habit
     *
     * @mbg.generated Thu Jun 27 22:40:32 CST 2019
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table habit
     *
     * @mbg.generated Thu Jun 27 22:40:32 CST 2019
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table habit
     *
     * @mbg.generated Thu Jun 27 22:40:32 CST 2019
     */
    public AnimalHabitExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table habit
     *
     * @mbg.generated Thu Jun 27 22:40:32 CST 2019
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table habit
     *
     * @mbg.generated Thu Jun 27 22:40:32 CST 2019
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table habit
     *
     * @mbg.generated Thu Jun 27 22:40:32 CST 2019
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table habit
     *
     * @mbg.generated Thu Jun 27 22:40:32 CST 2019
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table habit
     *
     * @mbg.generated Thu Jun 27 22:40:32 CST 2019
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table habit
     *
     * @mbg.generated Thu Jun 27 22:40:32 CST 2019
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table habit
     *
     * @mbg.generated Thu Jun 27 22:40:32 CST 2019
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table habit
     *
     * @mbg.generated Thu Jun 27 22:40:32 CST 2019
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table habit
     *
     * @mbg.generated Thu Jun 27 22:40:32 CST 2019
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table habit
     *
     * @mbg.generated Thu Jun 27 22:40:32 CST 2019
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table habit
     *
     * @mbg.generated Thu Jun 27 22:40:32 CST 2019
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEatIsNull() {
            addCriterion("eat is null");
            return (Criteria) this;
        }

        public Criteria andEatIsNotNull() {
            addCriterion("eat is not null");
            return (Criteria) this;
        }

        public Criteria andEatEqualTo(String value) {
            addCriterion("eat =", value, "eat");
            return (Criteria) this;
        }

        public Criteria andEatNotEqualTo(String value) {
            addCriterion("eat <>", value, "eat");
            return (Criteria) this;
        }

        public Criteria andEatGreaterThan(String value) {
            addCriterion("eat >", value, "eat");
            return (Criteria) this;
        }

        public Criteria andEatGreaterThanOrEqualTo(String value) {
            addCriterion("eat >=", value, "eat");
            return (Criteria) this;
        }

        public Criteria andEatLessThan(String value) {
            addCriterion("eat <", value, "eat");
            return (Criteria) this;
        }

        public Criteria andEatLessThanOrEqualTo(String value) {
            addCriterion("eat <=", value, "eat");
            return (Criteria) this;
        }

        public Criteria andEatLike(String value) {
            addCriterion("eat like", value, "eat");
            return (Criteria) this;
        }

        public Criteria andEatNotLike(String value) {
            addCriterion("eat not like", value, "eat");
            return (Criteria) this;
        }

        public Criteria andEatIn(List<String> values) {
            addCriterion("eat in", values, "eat");
            return (Criteria) this;
        }

        public Criteria andEatNotIn(List<String> values) {
            addCriterion("eat not in", values, "eat");
            return (Criteria) this;
        }

        public Criteria andEatBetween(String value1, String value2) {
            addCriterion("eat between", value1, value2, "eat");
            return (Criteria) this;
        }

        public Criteria andEatNotBetween(String value1, String value2) {
            addCriterion("eat not between", value1, value2, "eat");
            return (Criteria) this;
        }

        public Criteria andSleepIsNull() {
            addCriterion("sleep is null");
            return (Criteria) this;
        }

        public Criteria andSleepIsNotNull() {
            addCriterion("sleep is not null");
            return (Criteria) this;
        }

        public Criteria andSleepEqualTo(String value) {
            addCriterion("sleep =", value, "sleep");
            return (Criteria) this;
        }

        public Criteria andSleepNotEqualTo(String value) {
            addCriterion("sleep <>", value, "sleep");
            return (Criteria) this;
        }

        public Criteria andSleepGreaterThan(String value) {
            addCriterion("sleep >", value, "sleep");
            return (Criteria) this;
        }

        public Criteria andSleepGreaterThanOrEqualTo(String value) {
            addCriterion("sleep >=", value, "sleep");
            return (Criteria) this;
        }

        public Criteria andSleepLessThan(String value) {
            addCriterion("sleep <", value, "sleep");
            return (Criteria) this;
        }

        public Criteria andSleepLessThanOrEqualTo(String value) {
            addCriterion("sleep <=", value, "sleep");
            return (Criteria) this;
        }

        public Criteria andSleepLike(String value) {
            addCriterion("sleep like", value, "sleep");
            return (Criteria) this;
        }

        public Criteria andSleepNotLike(String value) {
            addCriterion("sleep not like", value, "sleep");
            return (Criteria) this;
        }

        public Criteria andSleepIn(List<String> values) {
            addCriterion("sleep in", values, "sleep");
            return (Criteria) this;
        }

        public Criteria andSleepNotIn(List<String> values) {
            addCriterion("sleep not in", values, "sleep");
            return (Criteria) this;
        }

        public Criteria andSleepBetween(String value1, String value2) {
            addCriterion("sleep between", value1, value2, "sleep");
            return (Criteria) this;
        }

        public Criteria andSleepNotBetween(String value1, String value2) {
            addCriterion("sleep not between", value1, value2, "sleep");
            return (Criteria) this;
        }

        public Criteria andPlaysIsNull() {
            addCriterion("plays is null");
            return (Criteria) this;
        }

        public Criteria andPlaysIsNotNull() {
            addCriterion("plays is not null");
            return (Criteria) this;
        }

        public Criteria andPlaysEqualTo(String value) {
            addCriterion("plays =", value, "plays");
            return (Criteria) this;
        }

        public Criteria andPlaysNotEqualTo(String value) {
            addCriterion("plays <>", value, "plays");
            return (Criteria) this;
        }

        public Criteria andPlaysGreaterThan(String value) {
            addCriterion("plays >", value, "plays");
            return (Criteria) this;
        }

        public Criteria andPlaysGreaterThanOrEqualTo(String value) {
            addCriterion("plays >=", value, "plays");
            return (Criteria) this;
        }

        public Criteria andPlaysLessThan(String value) {
            addCriterion("plays <", value, "plays");
            return (Criteria) this;
        }

        public Criteria andPlaysLessThanOrEqualTo(String value) {
            addCriterion("plays <=", value, "plays");
            return (Criteria) this;
        }

        public Criteria andPlaysLike(String value) {
            addCriterion("plays like", value, "plays");
            return (Criteria) this;
        }

        public Criteria andPlaysNotLike(String value) {
            addCriterion("plays not like", value, "plays");
            return (Criteria) this;
        }

        public Criteria andPlaysIn(List<String> values) {
            addCriterion("plays in", values, "plays");
            return (Criteria) this;
        }

        public Criteria andPlaysNotIn(List<String> values) {
            addCriterion("plays not in", values, "plays");
            return (Criteria) this;
        }

        public Criteria andPlaysBetween(String value1, String value2) {
            addCriterion("plays between", value1, value2, "plays");
            return (Criteria) this;
        }

        public Criteria andPlaysNotBetween(String value1, String value2) {
            addCriterion("plays not between", value1, value2, "plays");
            return (Criteria) this;
        }

        public Criteria andEmotionIsNull() {
            addCriterion("emotion is null");
            return (Criteria) this;
        }

        public Criteria andEmotionIsNotNull() {
            addCriterion("emotion is not null");
            return (Criteria) this;
        }

        public Criteria andEmotionEqualTo(String value) {
            addCriterion("emotion =", value, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionNotEqualTo(String value) {
            addCriterion("emotion <>", value, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionGreaterThan(String value) {
            addCriterion("emotion >", value, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionGreaterThanOrEqualTo(String value) {
            addCriterion("emotion >=", value, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionLessThan(String value) {
            addCriterion("emotion <", value, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionLessThanOrEqualTo(String value) {
            addCriterion("emotion <=", value, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionLike(String value) {
            addCriterion("emotion like", value, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionNotLike(String value) {
            addCriterion("emotion not like", value, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionIn(List<String> values) {
            addCriterion("emotion in", values, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionNotIn(List<String> values) {
            addCriterion("emotion not in", values, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionBetween(String value1, String value2) {
            addCriterion("emotion between", value1, value2, "emotion");
            return (Criteria) this;
        }

        public Criteria andEmotionNotBetween(String value1, String value2) {
            addCriterion("emotion not between", value1, value2, "emotion");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andDogWalkingIsNull() {
            addCriterion("dog_walking is null");
            return (Criteria) this;
        }

        public Criteria andDogWalkingIsNotNull() {
            addCriterion("dog_walking is not null");
            return (Criteria) this;
        }

        public Criteria andDogWalkingEqualTo(String value) {
            addCriterion("dog_walking =", value, "dogWalking");
            return (Criteria) this;
        }

        public Criteria andDogWalkingNotEqualTo(String value) {
            addCriterion("dog_walking <>", value, "dogWalking");
            return (Criteria) this;
        }

        public Criteria andDogWalkingGreaterThan(String value) {
            addCriterion("dog_walking >", value, "dogWalking");
            return (Criteria) this;
        }

        public Criteria andDogWalkingGreaterThanOrEqualTo(String value) {
            addCriterion("dog_walking >=", value, "dogWalking");
            return (Criteria) this;
        }

        public Criteria andDogWalkingLessThan(String value) {
            addCriterion("dog_walking <", value, "dogWalking");
            return (Criteria) this;
        }

        public Criteria andDogWalkingLessThanOrEqualTo(String value) {
            addCriterion("dog_walking <=", value, "dogWalking");
            return (Criteria) this;
        }

        public Criteria andDogWalkingLike(String value) {
            addCriterion("dog_walking like", value, "dogWalking");
            return (Criteria) this;
        }

        public Criteria andDogWalkingNotLike(String value) {
            addCriterion("dog_walking not like", value, "dogWalking");
            return (Criteria) this;
        }

        public Criteria andDogWalkingIn(List<String> values) {
            addCriterion("dog_walking in", values, "dogWalking");
            return (Criteria) this;
        }

        public Criteria andDogWalkingNotIn(List<String> values) {
            addCriterion("dog_walking not in", values, "dogWalking");
            return (Criteria) this;
        }

        public Criteria andDogWalkingBetween(String value1, String value2) {
            addCriterion("dog_walking between", value1, value2, "dogWalking");
            return (Criteria) this;
        }

        public Criteria andDogWalkingNotBetween(String value1, String value2) {
            addCriterion("dog_walking not between", value1, value2, "dogWalking");
            return (Criteria) this;
        }

        public Criteria andAnimalIdIsNull() {
            addCriterion("animal_id is null");
            return (Criteria) this;
        }

        public Criteria andAnimalIdIsNotNull() {
            addCriterion("animal_id is not null");
            return (Criteria) this;
        }

        public Criteria andAnimalIdEqualTo(Integer value) {
            addCriterion("animal_id =", value, "animalId");
            return (Criteria) this;
        }

        public Criteria andAnimalIdNotEqualTo(Integer value) {
            addCriterion("animal_id <>", value, "animalId");
            return (Criteria) this;
        }

        public Criteria andAnimalIdGreaterThan(Integer value) {
            addCriterion("animal_id >", value, "animalId");
            return (Criteria) this;
        }

        public Criteria andAnimalIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("animal_id >=", value, "animalId");
            return (Criteria) this;
        }

        public Criteria andAnimalIdLessThan(Integer value) {
            addCriterion("animal_id <", value, "animalId");
            return (Criteria) this;
        }

        public Criteria andAnimalIdLessThanOrEqualTo(Integer value) {
            addCriterion("animal_id <=", value, "animalId");
            return (Criteria) this;
        }

        public Criteria andAnimalIdIn(List<Integer> values) {
            addCriterion("animal_id in", values, "animalId");
            return (Criteria) this;
        }

        public Criteria andAnimalIdNotIn(List<Integer> values) {
            addCriterion("animal_id not in", values, "animalId");
            return (Criteria) this;
        }

        public Criteria andAnimalIdBetween(Integer value1, Integer value2) {
            addCriterion("animal_id between", value1, value2, "animalId");
            return (Criteria) this;
        }

        public Criteria andAnimalIdNotBetween(Integer value1, Integer value2) {
            addCriterion("animal_id not between", value1, value2, "animalId");
            return (Criteria) this;
        }

        public Criteria andWcHabitsIsNull() {
            addCriterion("wc_habits is null");
            return (Criteria) this;
        }

        public Criteria andWcHabitsIsNotNull() {
            addCriterion("wc_habits is not null");
            return (Criteria) this;
        }

        public Criteria andWcHabitsEqualTo(String value) {
            addCriterion("wc_habits =", value, "wcHabits");
            return (Criteria) this;
        }

        public Criteria andWcHabitsNotEqualTo(String value) {
            addCriterion("wc_habits <>", value, "wcHabits");
            return (Criteria) this;
        }

        public Criteria andWcHabitsGreaterThan(String value) {
            addCriterion("wc_habits >", value, "wcHabits");
            return (Criteria) this;
        }

        public Criteria andWcHabitsGreaterThanOrEqualTo(String value) {
            addCriterion("wc_habits >=", value, "wcHabits");
            return (Criteria) this;
        }

        public Criteria andWcHabitsLessThan(String value) {
            addCriterion("wc_habits <", value, "wcHabits");
            return (Criteria) this;
        }

        public Criteria andWcHabitsLessThanOrEqualTo(String value) {
            addCriterion("wc_habits <=", value, "wcHabits");
            return (Criteria) this;
        }

        public Criteria andWcHabitsLike(String value) {
            addCriterion("wc_habits like", value, "wcHabits");
            return (Criteria) this;
        }

        public Criteria andWcHabitsNotLike(String value) {
            addCriterion("wc_habits not like", value, "wcHabits");
            return (Criteria) this;
        }

        public Criteria andWcHabitsIn(List<String> values) {
            addCriterion("wc_habits in", values, "wcHabits");
            return (Criteria) this;
        }

        public Criteria andWcHabitsNotIn(List<String> values) {
            addCriterion("wc_habits not in", values, "wcHabits");
            return (Criteria) this;
        }

        public Criteria andWcHabitsBetween(String value1, String value2) {
            addCriterion("wc_habits between", value1, value2, "wcHabits");
            return (Criteria) this;
        }

        public Criteria andWcHabitsNotBetween(String value1, String value2) {
            addCriterion("wc_habits not between", value1, value2, "wcHabits");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table habit
     *
     * @mbg.generated do_not_delete_during_merge Thu Jun 27 22:40:32 CST 2019
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table habit
     *
     * @mbg.generated Thu Jun 27 22:40:32 CST 2019
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}