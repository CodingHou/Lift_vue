package com.hou.lift.service.impl;

import com.hou.lift.dao.TaskDetailMapper;
import com.hou.lift.model.Task;
import com.hou.lift.model.TaskDetail;
import com.hou.lift.model.TaskDetailExample;
import com.hou.lift.model.TaskExample;
import com.hou.lift.service.TaskDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskDetailServiceImpl implements TaskDetailService{

    @Autowired
    private TaskDetailMapper taskDetailMapper;

    @Override
    public List<TaskDetail> getTaskDetailList(Integer userId, Integer taskId) {
        TaskDetailExample example = new TaskDetailExample();
        TaskDetailExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andTaskIdEqualTo(taskId);
        List<TaskDetail> taskDetailList = taskDetailMapper.selectByExample(example);
        return taskDetailList;
    }

    @Override
    public int addTaskDetail(TaskDetail taskDetail) {
        int res = taskDetailMapper.insert(taskDetail);
        return res;
    }

    @Override
    public int updateTaskDetail(TaskDetail taskDetail) {
        int res = taskDetailMapper.updateByPrimaryKeySelective(taskDetail);
        return res;
    }

    @Override
    public int deleteTaskDetail(Integer taskDetailId) {
        int res = taskDetailMapper.deleteByPrimaryKey(taskDetailId);
        return res;
    }
}
