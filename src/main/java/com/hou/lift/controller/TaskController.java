package com.hou.lift.controller;


import com.hou.lift.enums.InitDetailEnum;
import com.hou.lift.model.Label;
import com.hou.lift.model.Task;
import com.hou.lift.model.TaskDetail;
import com.hou.lift.model.User;
import com.hou.lift.service.IUserService;
import com.hou.lift.service.LabelService;
import com.hou.lift.service.TaskDetailService;
import com.hou.lift.service.TaskService;
import com.hou.lift.util.BaseResult;
import com.hou.lift.util.DateUtil;
import com.hou.lift.util.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@RequestMapping("/task")
@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskDetailService taskDetailService;
    @Autowired
    private IUserService userService;
    @Autowired
    private LabelService labelService;

    //展示列表的方法
    @RequestMapping("/list")
    public String list(String userName, Integer userId, String taskName, ModelMap modelMap, HttpServletRequest request) throws ParseException {
//        int userId = (int) request.getAttribute("userId");
        if (StringUtils.isNotEmpty(userName)) {
            User user = userService.getUserByName(userName);
            userId = user.getUserId();
        }
        List<Task> taskList = taskService.getTaskList(userId,taskName);
        List<TaskDetail> detailList = new ArrayList<>();
        List<Label> labelList = labelService.getLabelList(userId);
//        初始化数据
        Task task = new Task();
        if (taskList.size() == 0) {
            task = initTask(userId);
            taskList.add(task);
            detailList = initDetailList(task);
        } else {
            task = taskList.get(0);
            detailList = taskDetailService.getTaskDetailList(userId, taskList.get(0).getTaskId());
        }
        modelMap.addAttribute("userId", userId);
        modelMap.addAttribute("taskName",taskName);
        modelMap.addAttribute("task", task);
        modelMap.addAttribute("labelList", labelList);
        modelMap.addAttribute("taskList", taskList);
        modelMap.addAttribute("detailList", detailList);
        return "/home";
    }




    @ResponseBody
    @RequestMapping("/insertTask")
    public String insertTask(Integer userId) {
        BaseResult baseResult = new BaseResult();
        Task task = new Task();
        task.setUserId(userId);
        task.setTaskName("新任务");
        task.setTotalDetail(0);
        task.setCompletedDetail(0);
        task.setDataState(1);
        task.setBeginDate(Calendar.getInstance().getTime());
        int c =taskService.addTask(task);
        if (c == 1) {
            baseResult.setStatus(true);
            baseResult.setData(task);
            baseResult.setMsg("保存成功!");
        } else {
            baseResult.setStatus(false);
            baseResult.setMsg("保存失败");
        }
        return JsonUtils.toJson(baseResult);
    }

    @ResponseBody
    @RequestMapping("/updateTask")
    public HashMap<String, Object> updateTask(Task task,String del,String createTime) throws ParseException {
        BaseResult baseResult = new BaseResult();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (StringUtils.isNotEmpty(createTime)) {
            task.setBeginDate(sdf.parse(createTime));
        }
        if ("yes".equals(del)) {
            task.setDataState(2);
        }
        int c =taskService.updateTask(task);
        if (c == 1) {
            baseResult.setStatus(true);
            baseResult.setMsg("保存成功!");
        } else {
            baseResult.setStatus(false);
            baseResult.setMsg("保存失败");
        }
        return JsonUtils.toHashMap(baseResult);
    }

    private Task initTask(Integer userId) throws ParseException {
        Task initTask = new Task();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        initTask.setBeginDate(sdf.parse(DateUtil.getNowDate()));
        initTask.setTaskName("新任务");
        initTask.setLabelId(1);
        initTask.setTotalDetail(5);
        initTask.setCompletedDetail(1);
        initTask.setUserId(userId);
        initTask.setDataState(1);
        taskService.addTask(initTask);
        return initTask;
    }

    private List<TaskDetail> initDetailList(Task initTask) throws ParseException {
        List<TaskDetail> detailList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 5; i++) {
            TaskDetail detail = new TaskDetail();
            detail.setTaskDetailName(InitDetailEnum.getName(i+1));
            detail.setDataState(1);
            if (i == 1) {
                detail.setDataState(2);
            }
            detail.setLabelId(initTask.getLabelId());
            detail.setTaskId(initTask.getTaskId());
            detail.setUserId(initTask.getUserId());
            detail.setCreateTime(sdf.parse(DateUtil.getNowDate()));
            taskDetailService.addTaskDetail(detail);
            detailList.add(detail);
        }
        return detailList;
    }
    //增删改查


}
