package com.hou.lift.service;

import com.hou.lift.model.Task;

import java.util.List;

public interface TaskService {

    public List<Task> getTaskList(Integer userId,String taskName);

    public Task getTaskById(Integer taskId);

    public int addTask(Task task);

    public int updateTask(Task task);

    public int deleteTask(Integer taskId);


}
