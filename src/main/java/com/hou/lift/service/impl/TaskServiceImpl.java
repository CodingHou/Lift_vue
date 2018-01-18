package com.hou.lift.service.impl;

import com.hou.lift.dao.TaskMapper;
import com.hou.lift.model.Task;
import com.hou.lift.model.TaskExample;
import com.hou.lift.param.TaskQueryParam;
import com.hou.lift.service.TaskService;
import io.swagger.models.auth.In;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public List<Task> getTaskList(TaskQueryParam taskQueryParam) {
        TaskExample example = new TaskExample();
        TaskExample.Criteria criteria = example.createCriteria();
        int userId = taskQueryParam.getUserId();
        String labels = taskQueryParam.getLabels();
        criteria.andUserIdEqualTo(userId);
        criteria.andDataStateNotEqualTo(2);
        if (StringUtils.isNotEmpty(taskQueryParam.getTaskName())) {
            criteria.andTaskNameLike("%" + taskQueryParam.getTaskName() + "%");
        }
        if (StringUtils.isNotEmpty(taskQueryParam.getLabels())) {
            List<Integer> labelList = new ArrayList<>();
            String[] labelArr = taskQueryParam.getLabels().split(",");
            for (String labelId : labelArr) {
                Integer label = Integer.valueOf(labelId);
                labelList.add(label);
            }
            criteria.andLabelIdIn(labelList);
        }
        example.setOrderByClause("task_id desc");
//        example.setOrderByClause("task_id asc");
        List<Task> taskList = taskMapper.selectByExample(example);
        return taskList;
    }

    @Override
    public List<Task> getDeleteTask(Integer userId, String taskName) {
        TaskExample example = new TaskExample();
        TaskExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andDataStateEqualTo(2);
        if (StringUtils.isNotEmpty(taskName)) {
            criteria.andTaskNameLike("%" + taskName + "%");
        }
        example.setOrderByClause("update_date desc");
//        example.setOrderByClause("task_id asc");
        List<Task> taskList = taskMapper.selectByExample(example);
        return taskList;
    }

    @Override
    public int checkTaskIsNull(Integer userId) {
        // 查找该user下的所有task，包括删除的。
        TaskExample example = new TaskExample();
        TaskExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        example.setOrderByClause("task_id desc");
        int count = taskMapper.countByExample(example);
        return count;
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
