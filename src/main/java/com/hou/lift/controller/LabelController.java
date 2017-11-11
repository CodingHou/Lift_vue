package com.hou.lift.controller;

import com.hou.lift.model.Label;
import com.hou.lift.service.LabelService;
import com.hou.lift.util.BaseResult;
import com.hou.lift.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelService labelService;

    //展示列表的方法
    @RequestMapping("/getLabelList")
    public String getLabelList(Integer userId, ModelMap modelMap,Integer labelId,  HttpServletRequest request) throws ParseException {
        userId = (Integer) request.getSession().getAttribute("userId");
        List<Label> labelList = labelService.getLabelList(userId);
        modelMap.addAttribute("labelId", labelId);
        modelMap.addAttribute("userId", userId);
        modelMap.addAttribute("labelList", labelList);
        return "/labelList";
    }

    @ResponseBody
    @RequestMapping("/checkInUse")
    public Boolean checkInUse(Integer userId,Integer labelId) {
        boolean c = labelService.checkInUse(userId, labelId);
        return c;
    }

    @ResponseBody
    @RequestMapping("/insertLabel")
    public String insertTask(Integer userId,Label label) {
        BaseResult baseResult = new BaseResult();
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

    @ResponseBody
    @RequestMapping("/updateLabel")
    public HashMap<String, Object> updateLabel(Label label,String del) throws ParseException {
        BaseResult baseResult = new BaseResult();
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
