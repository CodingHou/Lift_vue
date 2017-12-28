package com.hou.lift.controller;

import com.hou.lift.model.Task;
import com.hou.lift.model.TaskDetail;
import com.hou.lift.service.TaskDetailService;
import com.hou.lift.service.TaskService;
import com.hou.lift.util.BaseResult;
import com.hou.lift.util.JsonUtil;
import com.hou.lift.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/taskDetail", produces = "application/json; charset=utf-8")
public class TaskDetailController {


    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskDetailService taskDetailService;

    @RequestMapping("/list")
    public String list(Integer userId, Integer taskId, Integer isDel, ModelMap modelMap) {
        List<TaskDetail> detailList = new ArrayList<>();
        Task task = taskService.getTaskById(taskId);
        detailList = taskDetailService.getTaskDetailList(userId, taskId);
        modelMap.addAttribute("isDel", isDel);
        modelMap.addAttribute("detailList", detailList);
        modelMap.addAttribute("task", task);
        return "/details";
    }

//    @ResponseBody
    @RequestMapping(value = "/getDetailJson", produces = "application/json; charset=utf-8")
    public String getDetailJson(Integer userId, Integer taskId) {
        List<TaskDetail> detailList = taskDetailService.getTaskDetailList(userId, taskId);
        BaseResult baseResult = new BaseResult();
        baseResult.setData(detailList);
        baseResult.setStatus(true);
        baseResult.setMsg("查询明细成功");
        return JsonUtils.toJson(baseResult);
    }

//    @ResponseBody
    @RequestMapping("/insertTaskDetail")
    public HashMap insertTaskDetail(TaskDetail taskDetail) {
        BaseResult baseResult = new BaseResult();
        Task task = taskService.getTaskById(taskDetail.getTaskId());
        taskDetail.setLabelId(task.getLabelId());
        taskDetail.setGradeId(task.getGradeId());
        taskDetail.setDataState(1);
        int c = taskDetailService.addTaskDetail(taskDetail);
        if (c == 1) {
            baseResult.setStatus(true);
            baseResult.setMsg("保存成功!");
            baseResult.setData(taskDetail.getTaskDetailId());
        } else {
            baseResult.setStatus(false);
            baseResult.setMsg("保存失败");
        }
        return JsonUtils.toHashMap(baseResult);

    }


//    @ResponseBody
    @RequestMapping("/updateTaskDetail")
    public String updateTaskDetail(TaskDetail taskDetail, Boolean isChecked, String actionType, Integer checkedNo, Integer totalNo) {
        BaseResult baseResult = new BaseResult();
        int c = 0;
        if ("update".equals(actionType)) {
            if (isChecked) {
                taskDetail.setDataState(2);
            } else {
                taskDetail.setDataState(1);
            }
        } else if ("del".equals(actionType)) {
            taskDetail.setDataState(3);
        }
        if (null != checkedNo && null != totalNo) {
            Task task = taskService.getTaskById(taskDetail.getTaskId());
            task.setCompletedDetail(checkedNo);
            task.setTotalDetail(totalNo);
            taskService.updateTask(task);
        }
        c = taskDetailService.updateTaskDetail(taskDetail);
        if (c == 1) {
            baseResult.setStatus(true);
            baseResult.setMsg("保存成功!");
        } else {
            baseResult.setStatus(false);
            baseResult.setMsg("保存失败");
        }
        return JsonUtils.toJson(baseResult);

    }
//    @ResponseBody
    @RequestMapping(value = "/updateDetail", produces = "application/json; charset=utf-8",method = {RequestMethod.GET,RequestMethod.POST})
    public String updateDetail(TaskDetail taskDetail, String actionType, Integer checkedNo, Integer totalNo) {
        BaseResult baseResult = new BaseResult();
        int c = 0;
        if ("del".equals(actionType)) {
            taskDetail.setDataState(3);
        }

        c = taskDetailService.updateTaskDetail(taskDetail);
        if (c == 1) {
            baseResult.setStatus(true);
            baseResult.setMsg("保存成功!");
        } else {
            baseResult.setStatus(false);
            baseResult.setMsg("保存失败");
        }
        return JsonUtils.toJson(baseResult);

    }

}
