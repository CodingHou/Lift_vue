package com.hou.lift.service.impl;

import com.hou.lift.dao.TaskMapper;
import com.hou.lift.model.Task;
import com.hou.lift.model.TaskExample;
import com.hou.lift.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<Task> getTaskList(Integer userId) {
        TaskExample example = new TaskExample();
        TaskExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andDataStateNotEqualTo(2);
        example.setOrderByClause("task_id desc");
//        example.setOrderByClause("task_id asc");
        List<Task> taskList = taskMapper.selectByExample(example);
        return taskList;
    }

    @Override
    public Task getTaskById(Integer taskId) {
        Task task = taskMapper.selectByPrimaryKey(taskId);
        return task;
    }

    @Override
    public int addTask(Task task) {
        task.setCreateDate(Calendar.getInstance().getTime());
        int res = taskMapper.insert(task);
        return res;
    }

    @Override
    public int updateTask(Task task) {
        task.setUpdateDate(Calendar.getInstance().getTime());
        int res = taskMapper.updateByPrimaryKeySelective(task);
        return res;
    }

    @Override
    public int deleteTask(Integer taskId) {
        int res = taskMapper.deleteByPrimaryKey(taskId);
        return res;
    }
}
