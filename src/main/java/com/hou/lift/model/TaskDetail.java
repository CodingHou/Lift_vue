package com.hou.lift.model;

import java.util.Date;

public class TaskDetail {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_detail.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_detail.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_detail.task_id
     *
     * @mbggenerated
     */
    private Integer taskId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_detail.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_detail.data_state
     *
     * @mbggenerated
     */
    private Integer dataState;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_detail.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_detail.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_detail.label
     *
     * @mbggenerated
     */
    private Integer label;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task_detail.grade
     *
     * @mbggenerated
     */
    private Integer grade;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_detail.id
     *
     * @return the value of task_detail.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_detail.id
     *
     * @param id the value for task_detail.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_detail.user_id
     *
     * @return the value of task_detail.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_detail.user_id
     *
     * @param userId the value for task_detail.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_detail.task_id
     *
     * @return the value of task_detail.task_id
     *
     * @mbggenerated
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_detail.task_id
     *
     * @param taskId the value for task_detail.task_id
     *
     * @mbggenerated
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_detail.name
     *
     * @return the value of task_detail.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_detail.name
     *
     * @param name the value for task_detail.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_detail.data_state
     *
     * @return the value of task_detail.data_state
     *
     * @mbggenerated
     */
    public Integer getDataState() {
        return dataState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_detail.data_state
     *
     * @param dataState the value for task_detail.data_state
     *
     * @mbggenerated
     */
    public void setDataState(Integer dataState) {
        this.dataState = dataState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_detail.create_time
     *
     * @return the value of task_detail.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_detail.create_time
     *
     * @param createTime the value for task_detail.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_detail.update_time
     *
     * @return the value of task_detail.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_detail.update_time
     *
     * @param updateTime the value for task_detail.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_detail.label
     *
     * @return the value of task_detail.label
     *
     * @mbggenerated
     */
    public Integer getLabel() {
        return label;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_detail.label
     *
     * @param label the value for task_detail.label
     *
     * @mbggenerated
     */
    public void setLabel(Integer label) {
        this.label = label;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task_detail.grade
     *
     * @return the value of task_detail.grade
     *
     * @mbggenerated
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task_detail.grade
     *
     * @param grade the value for task_detail.grade
     *
     * @mbggenerated
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}