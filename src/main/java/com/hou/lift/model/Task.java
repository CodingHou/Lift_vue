package com.hou.lift.model;

import java.util.Date;

public class Task {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.task_id
     *
     * @mbggenerated
     */
    private Integer taskId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.task_name
     *
     * @mbggenerated
     */
    private String taskName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.begin_date
     *
     * @mbggenerated
     */
    private Date beginDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.label_name
     *
     * @mbggenerated
     */
    private String labelName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.label_id
     *
     * @mbggenerated
     */
    private Integer labelId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.grade_id
     *
     * @mbggenerated
     */
    private Integer gradeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.total_detail
     *
     * @mbggenerated
     */
    private Integer totalDetail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.completed_detail
     *
     * @mbggenerated
     */
    private Integer completedDetail;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.create_date
     *
     * @mbggenerated
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.update_date
     *
     * @mbggenerated
     */
    private Date updateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column task.data_state
     *
     * @mbggenerated
     */
    private Integer dataState;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.task_id
     *
     * @return the value of task.task_id
     *
     * @mbggenerated
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.task_id
     *
     * @param taskId the value for task.task_id
     *
     * @mbggenerated
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.task_name
     *
     * @return the value of task.task_name
     *
     * @mbggenerated
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.task_name
     *
     * @param taskName the value for task.task_name
     *
     * @mbggenerated
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.user_id
     *
     * @return the value of task.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.user_id
     *
     * @param userId the value for task.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.begin_date
     *
     * @return the value of task.begin_date
     *
     * @mbggenerated
     */
    public Date getBeginDate() {
        return beginDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.begin_date
     *
     * @param beginDate the value for task.begin_date
     *
     * @mbggenerated
     */
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.label_name
     *
     * @return the value of task.label_name
     *
     * @mbggenerated
     */
    public String getLabelName() {
        return labelName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.label_name
     *
     * @param labelName the value for task.label_name
     *
     * @mbggenerated
     */
    public void setLabelName(String labelName) {
        this.labelName = labelName == null ? null : labelName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.label_id
     *
     * @return the value of task.label_id
     *
     * @mbggenerated
     */
    public Integer getLabelId() {
        return labelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.label_id
     *
     * @param labelId the value for task.label_id
     *
     * @mbggenerated
     */
    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.grade_id
     *
     * @return the value of task.grade_id
     *
     * @mbggenerated
     */
    public Integer getGradeId() {
        return gradeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.grade_id
     *
     * @param gradeId the value for task.grade_id
     *
     * @mbggenerated
     */
    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.total_detail
     *
     * @return the value of task.total_detail
     *
     * @mbggenerated
     */
    public Integer getTotalDetail() {
        return totalDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.total_detail
     *
     * @param totalDetail the value for task.total_detail
     *
     * @mbggenerated
     */
    public void setTotalDetail(Integer totalDetail) {
        this.totalDetail = totalDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.completed_detail
     *
     * @return the value of task.completed_detail
     *
     * @mbggenerated
     */
    public Integer getCompletedDetail() {
        return completedDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.completed_detail
     *
     * @param completedDetail the value for task.completed_detail
     *
     * @mbggenerated
     */
    public void setCompletedDetail(Integer completedDetail) {
        this.completedDetail = completedDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.create_date
     *
     * @return the value of task.create_date
     *
     * @mbggenerated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.create_date
     *
     * @param createDate the value for task.create_date
     *
     * @mbggenerated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.update_date
     *
     * @return the value of task.update_date
     *
     * @mbggenerated
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.update_date
     *
     * @param updateDate the value for task.update_date
     *
     * @mbggenerated
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column task.data_state
     *
     * @return the value of task.data_state
     *
     * @mbggenerated
     */
    public Integer getDataState() {
        return dataState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column task.data_state
     *
     * @param dataState the value for task.data_state
     *
     * @mbggenerated
     */
    public void setDataState(Integer dataState) {
        this.dataState = dataState;
    }
}