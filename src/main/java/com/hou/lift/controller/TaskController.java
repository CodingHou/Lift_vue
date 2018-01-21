package com.hou.lift.controller;

import com.hou.lift.enums.DelDetailEnum;
import com.hou.lift.enums.InitDetailEnum;
import com.hou.lift.model.*;
import com.hou.lift.param.TaskQueryParam;
import com.hou.lift.service.*;
import com.hou.lift.util.BaseResult;
import com.hou.lift.util.DateUtil;
import com.hou.lift.util.JsonUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/task" ,produces = "application/json; charset=utf-8",method = {RequestMethod.GET})
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskDetailService taskDetailService;
    @Autowired
    private IUserService userService;
    @Autowired
    private LabelService labelService;
    @Autowired
    private NoteService noteService;



    @RequestMapping("/getTaskList")
    @ApiOperation(value = "获取TaskList",notes = "返回该用户下的task列表")
    public String getTaskList(TaskQueryParam taskQueryParam, String signInType, HttpServletRequest request) throws ParseException {
        HttpSession session = request.getSession();
        BaseResult result = new BaseResult();
        Integer userId =taskQueryParam.getUserId();
        if (null == userId) {
            userId = (Integer) session.getAttribute("userId");
        }
        taskQueryParam.setUserId(userId);
        List<Task> taskList  = taskService.getTaskList(taskQueryParam);
        result.setData(taskList);
        for (int i = 0; i < taskList.size(); i++) {
            Date beginDate = taskList.get(i).getBeginDate();
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            taskList.get(i).setBeginDate(sdf.parse(sdf.format(beginDate)));
        }
        int count = taskService.checkTaskIsNull(userId);
        //如果是注册后首次登录
        if (count == 0) {
            List<Label> labelList = initLabel(userId);
            Task task = initTask(userId, labelList.get(0));
            taskList.add(task);
            List<TaskDetail> detailList = initDetailList(task);
            Task delTask = initDelTask(userId,labelList.get(0));
            List<TaskDetail> delDetail = initDelDetail(delTask);
        }
        result.setMsg("查询任务列表成功");
        result.setStatus(true);
        return JsonUtils.toJson(result);
    }


    //展示列表的方法
    @RequestMapping("/getDelTask")
    public String getDelTask(Integer userId, String taskName, String signInType, ModelMap modelMap, HttpServletRequest request) throws ParseException {
        HttpSession session = request.getSession();
        BaseResult result = new BaseResult();
        if (null == userId) {
            userId = (Integer) session.getAttribute("userId");
        }
        //默认选中第一个task，并展示其Detail
        List<Task> taskList = taskService.getDeleteTask(userId, taskName);
        List<TaskDetail> detailList = new ArrayList<>();
        List<Label> labelList = labelService.getLabelList(userId);
        Task task = new Task();
        if (taskList.size() > 0) {
            task = taskList.get(0);
            detailList = taskDetailService.getTaskDetailList(userId, taskList.get(0).getTaskId());
        }

        result.setData(taskList);
        result.setMsg("查询任务列表成功");
        result.setStatus(true);
        return JsonUtils.toJson(result);
    }

    @RequestMapping("/insertTask")
    @ApiOperation(value = "新增task的方法")
    public String insertTask(@ApiParam("用户id") Integer userId,HttpServletRequest request) {
        BaseResult baseResult = new BaseResult();
        HttpSession session = request.getSession();
        if (null == userId) {
            userId = (Integer) session.getAttribute("userId");
        }
        Task task = new Task();
        task.setUserId(userId);
        task.setTaskName("新任务");
        task.setTotalDetail(0);
        task.setCompletedDetail(0);
        task.setGradeId(3);
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

    @ApiOperation(value = "更新和删除task的方法",notes = "测试参数和返回值")
    @RequestMapping(value = "/updateTask", produces = "application/json; charset=utf-8")
    public String updateTask(@ApiParam("task需要修改的属性，taskId为必传") Task task, String del, String beginTime) throws ParseException {
        BaseResult baseResult = new BaseResult();
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (StringUtils.isNotEmpty(beginTime)) {
            task.setBeginDate(sdf.parse(beginTime));
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
        return JsonUtils.toJson(baseResult);
    }

    @RequestMapping("/revertTask")
    public String revertTask(Task task) throws ParseException {
        BaseResult baseResult = new BaseResult();
        task.setDataState(1);
        int c = taskService.updateTask(task);
        if (c == 1) {
            baseResult.setStatus(true);
            baseResult.setMsg("保存成功!");
        } else {
            baseResult.setStatus(false);
            baseResult.setMsg("保存失败");
        }
        return JsonUtils.toJson(baseResult);
    }


    @RequestMapping("/deleteTask")
    public String deleteTask(Task task) throws ParseException {
        BaseResult baseResult = new BaseResult();
        int c = taskService.deleteTask(task.getTaskId());
        if (c == 1) {
            baseResult.setStatus(true);
            baseResult.setMsg("删除成功!");
        } else {
            baseResult.setStatus(false);
            baseResult.setMsg("删除失败");
        }
        return JsonUtils.toJson(baseResult);
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
        initTask.setTotalDetail(InitDetailEnum.values().length);
        initTask.setCompletedDetail(1);
        initTask.setUserId(userId);
        initTask.setDataState(1);
        taskService.addTask(initTask);
        Note note = new Note();
        note.setUserId(userId);
        note.setContent("这是您的第一个便签。请在此记录您的想法吧。");
        noteService.addNote(note);
        return initTask;
    }
    //初始化task
    private Task initDelTask(Integer userId, Label label) throws ParseException {
        Task delTask = new Task();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        delTask.setBeginDate(sdf.parse(DateUtil.getNowDate()));
        delTask.setTaskName("这是您的垃圾桶页面");
        delTask.setLabelId(label.getLabelId());
        delTask.setLabelName(label.getLabelName());
        delTask.setTotalDetail(DelDetailEnum.values().length);
        delTask.setCompletedDetail(1);
        delTask.setUserId(userId);
        delTask.setDataState(2);
        delTask.setGradeId(3);
        taskService.addTask(delTask);
        return delTask;
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

    //初始化Detail
    private List<TaskDetail> initDelDetail(Task delTask) throws ParseException {
        List<TaskDetail> detailList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < DelDetailEnum.values().length; i++) {
            TaskDetail detail = new TaskDetail();
            detail.setTaskDetailName(DelDetailEnum.getName(i + 1));
            detail.setDataState(1);
            //将第二个设置为选中
            if (i == 1) {
                detail.setDataState(2);
            }
            detail.setLabelId(delTask.getLabelId());
            detail.setTaskId(delTask.getTaskId());
            detail.setUserId(delTask.getUserId());
            detail.setCreateTime(sdf.parse(DateUtil.getNowDate()));
            taskDetailService.addTaskDetail(detail);
            detailList.add(detail);
        }
        return detailList;
    }




}

