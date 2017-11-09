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
    public String list(String userName, Integer userId, String taskName, String signInType, ModelMap modelMap, HttpServletRequest request) throws ParseException {
        //int userId = (int) request.getAttribute("userId");
        if (StringUtils.isNotEmpty(userName)) {
            User user = userService.getUserByName(userName);
            userId = user.getUserId();
        }
        Task task = new Task();
        List<Task> taskList = new ArrayList<>();
        List<TaskDetail> detailList = new ArrayList<>();
        List<Label> labelList = new ArrayList<>();
        int count = taskService.checkTaskIsNull(userId);
        //如果是注册后首次登录
        if (count == 0) {
            labelList = initLabel(userId);
            task = initTask(userId, labelList.get(0));
            taskList.add(task);
            detailList = initDetailList(task);
        } else {
            taskList = taskService.getTaskList(userId, taskName);
            //默认选中第一个task，并展示其Detail
            task = taskList.get(0);
            detailList = taskDetailService.getTaskDetailList(userId, taskList.get(0).getTaskId());
            labelList = labelService.getLabelList(userId);
        }

        modelMap.addAttribute("userId", userId);
        modelMap.addAttribute("taskName", taskName);
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
        int c = taskService.addTask(task);
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
    public HashMap<String, Object> updateTask(Task task, String del, String createTime) throws ParseException {
        BaseResult baseResult = new BaseResult();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (StringUtils.isNotEmpty(createTime)) {
            task.setBeginDate(sdf.parse(createTime));
        }
        if ("yes".equals(del)) {
            task.setDataState(2);
        }
        int c = taskService.updateTask(task);
        if (c == 1) {
            baseResult.setStatus(true);
            baseResult.setMsg("保存成功!");
        } else {
            baseResult.setStatus(false);
            baseResult.setMsg("保存失败");
        }
        return JsonUtils.toHashMap(baseResult);
    }

    //新用户首次登录时初始化label
    private List<Label> initLabel(Integer userId) {
        List<Label> labelList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Label label = new Label();
            if (i == 0) {
                label.setLabelName("家");
            } else {
                label.setLabelName("公司");
            }
            label.setUserId(userId);
            label.setDataState(1);
            label.setCreateDate(Calendar.getInstance().getTime());
            labelService.addLabel(label);
            labelList.add(label);
        }
        return labelList;
    }

    //初始化task
    private Task initTask(Integer userId, Label label) throws ParseException {
        Task initTask = new Task();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        initTask.setBeginDate(sdf.parse(DateUtil.getNowDate()));
        initTask.setTaskName("这是您的第一个任务");
        initTask.setLabelId(label.getLabelId());
        initTask.setLabelName(label.getLabelName());
        initTask.setTotalDetail(6);
        initTask.setCompletedDetail(1);
        initTask.setUserId(userId);
        initTask.setDataState(1);
        taskService.addTask(initTask);
        return initTask;
    }

    //初始化Detail
    private List<TaskDetail> initDetailList(Task initTask) throws ParseException {
        List<TaskDetail> detailList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < InitDetailEnum.values().length; i++) {
            TaskDetail detail = new TaskDetail();
            detail.setTaskDetailName(InitDetailEnum.getName(i + 1));
            detail.setDataState(1);
            //将第二个设置为选中
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


}
