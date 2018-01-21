package com.hou.lift.controller;

import com.hou.lift.model.Label;
import com.hou.lift.service.LabelService;
import com.hou.lift.util.BaseResult;
import com.hou.lift.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/label",produces = "application/json; charset=utf-8",method = {RequestMethod.GET})
public class LabelController {

    @Autowired
    private LabelService labelService;

//    //展示列表的方法
//    @RequestMapping("/getLabelList")
//    public String getLabelList(Integer userId, ModelMap modelMap,Integer labelId,  HttpServletRequest request) throws ParseException {
//        userId = (Integer) request.getSession().getAttribute("userId");
//        List<Label> labelList = labelService.getLabelList(userId);
//        modelMap.addAttribute("labelId", labelId);
//        modelMap.addAttribute("userId", userId);
//        modelMap.addAttribute("labelList", labelList);
//        return "/labelList";
//    }
    //展示列表的方法

    @RequestMapping("/getLabelList")
    public String getLabelList(Integer userId, Integer labelId,  HttpServletRequest request) throws ParseException {
        if (null == userId) {
            userId = (Integer) request.getSession().getAttribute("userId");
        }
        List<Label> labelList = labelService.getLabelList(userId);
        BaseResult baseResult = new BaseResult();
        baseResult.setData(labelList);
        baseResult.setStatus(true);
        baseResult.setMsg("查询标签成功");
        return JsonUtils.toJson(baseResult);
    }


    @RequestMapping("/checkInUse")
    public Boolean checkInUse(Integer userId,Integer labelId) {
        boolean c = labelService.checkInUse(userId, labelId);
        return c;
    }


    @RequestMapping("/insertLabel")
    public String insertTask(Integer userId,Label label,HttpServletRequest request) {
        BaseResult baseResult = new BaseResult();
        HttpSession session = request.getSession();
        if (null == userId) {
            userId = (Integer) session.getAttribute("userId");
        }
        label.setUserId(userId);
        int c =labelService.addLabel(label);
        if (c == 1) {
            baseResult.setStatus(true);
            baseResult.setData(label.getLabelId());
            baseResult.setMsg("保存成功!");
        } else {
            baseResult.setStatus(false);
            baseResult.setMsg("保存失败");
        }
        return JsonUtils.toJson(baseResult);
    }


    @RequestMapping(value = "/updateLabel",produces = "application/json; charset=utf-8")
    public HashMap<String, Object> updateLabel(Label label,String del,HttpServletRequest request) throws ParseException {
        BaseResult baseResult = new BaseResult();
        HttpSession session = request.getSession();
        if (null == label.getUserId()) {
            int userId = (Integer) session.getAttribute("userId");
            label.setUserId(userId);
        }
        Boolean res = checkInUse(label.getUserId(), label.getLabelId());
        if ("yes".equals(del)) {
            label.setDataState(2);
            if (res) {
                baseResult.setData(1);
                baseResult.setStatus(false);
                return JsonUtils.toHashMap(baseResult);
            }
        }
        int c =labelService.updateLabel(label);
        if (c == 1) {
            baseResult.setStatus(true);
            baseResult.setMsg("保存成功!");
        } else {
            baseResult.setStatus(false);
            baseResult.setMsg("保存失败");
        }
        return JsonUtils.toHashMap(baseResult);
    }



}
