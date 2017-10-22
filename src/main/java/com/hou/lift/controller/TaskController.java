package com.hou.lift.controller;


import com.hou.lift.enums.InitDetailEnum;
import com.hou.lift.model.Task;
import com.hou.lift.model.TaskDetail;
import com.hou.lift.model.User;
import com.hou.lift.service.IUserService;
import com.hou.lift.service.TaskDetailService;
import com.hou.lift.service.TaskService;
import com.hou.lift.util.DateUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

    //展示列表的方法
    @RequestMapping("/list")
    public String list(String userName,Integer userId, ModelMap modelMap, HttpServletRequest request) throws ParseException {
//        int userId = (int) request.getAttribute("userId");
        User user = userService.getUserByName(userName);
        userId = user.getId();
        List<Task> taskList = taskService.getTaskList(user.getId());
        Task initTask = initTask(userId);
        taskList.add(initTask);
        List<TaskDetail> detailList = initDetailList(initTask);
        modelMap.addAttribute("task", initTask);
        modelMap.addAttribute("taskList", taskList);
        modelMap.addAttribute("detaiList", detailList);
        return "/home";
    }

    @RequestMapping("/getTaskDetail")
    public String getTaskDetail(Integer userId,Integer taskId,ModelMap modelMap) {
        List<TaskDetail> taskDetailList = taskDetailService.getTaskDetailList(userId,taskId);
        modelMap.addAttribute("taskDetailList", taskDetailList);
        return "/home";
    }


    private Task initTask(Integer userId) throws ParseException {
        Task initTask = new Task();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        initTask.setBeginDate(sdf.parse(DateUtil.getNowDate()));
        initTask.setName("新任务");
        initTask.setLabel(1);
        initTask.setTotalDetail(5);
        initTask.setCompletedDetail(1);
        initTask.setUserId(userId);
        taskService.addTask(initTask);
        return initTask;
    }

    private List<TaskDetail> initDetailList(Task initTask) throws ParseException {
        List<TaskDetail> detailList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        for (int i = 0; i < 5; i++) {
            TaskDetail detail = new TaskDetail();
            detail.setName(InitDetailEnum.getName(i+1));
            detail.setDataState(1);
            detail.setLabel(initTask.getLabel());
            detail.setTaskId(initTask.getId());
            detail.setUserId(initTask.getUserId());
            detail.setCreateTime(sdf.parse(DateUtil.getNowDate()));
            taskDetailService.addTaskDetail(detail);
            detailList.add(detail);
        }
        return detailList;
    }
    //增删改查


}
