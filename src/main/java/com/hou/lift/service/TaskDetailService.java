package com.hou.lift.service;

import com.hou.lift.model.TaskDetail;

import java.util.List;

public interface TaskDetailService {

    public List<TaskDetail> getTaskDetailList(Integer userId, Integer taskId);

    public int addTaskDetail(TaskDetail taskDetail);

    public int updateTaskDetail(TaskDetail taskDetail);

    public int deleteTaskDetail(Integer taskDetailId);

}
