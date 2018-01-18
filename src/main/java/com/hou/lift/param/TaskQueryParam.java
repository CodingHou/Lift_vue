package com.hou.lift.param;

import java.util.Date;

public class TaskQueryParam {
    private Integer taskId;


    private String taskName;

    private Integer userId;

    private Date beginDate;

    private String labelName;

    private Integer labelId;

    private Integer gradeId;

    private Integer totalDetail;

    private Integer completedDetail;

    private Date createDate;

    private Date updateDate;

    private Integer dataState;

    private String labels;

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getTotalDetail() {
        return totalDetail;
    }

    public void setTotalDetail(Integer totalDetail) {
        this.totalDetail = totalDetail;
    }

    public Integer getCompletedDetail() {
        return completedDetail;
    }

    public void setCompletedDetail(Integer completedDetail) {
        this.completedDetail = completedDetail;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getDataState() {
        return dataState;
    }

    public void setDataState(Integer dataState) {
        this.dataState = dataState;
    }

    public String getLabels() {
        return labels;
    }

    public void setLabels(String labels) {
        this.labels = labels;
    }
}
