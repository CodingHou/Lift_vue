package com.hou.lift.controller;

import com.hou.lift.cons.Constants;
import com.hou.lift.model.User;
import com.hou.lift.service.IUserService;
import com.hou.lift.util.BaseResult;
import com.hou.lift.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;


@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/index")
    public String index() {
        return "/index";
    }

    //注册
    @ResponseBody
    @RequestMapping("/signUp")
    public String signUp(User user, ModelMap modelMap, String repPwd) {
        userService.addUser(user);
        return "/main";
    }

    //登录
    @ResponseBody
    @RequestMapping("signIn")
    public HashMap<String, Object> signIn(User user, String password, HttpServletRequest request) {
        BaseResult baseResult = new BaseResult();
        user = userService.getUserByName(user.getUserName());
        request.setAttribute("userId", user.getUserId());
        if (user != null) {
            if (password.equals(user.getPassword())) {
                baseResult.setStatus(true);
                baseResult.setMsg("登录成功!");
            } else {
                baseResult.setStatus(false);
                baseResult.setMsg("密码不正确！");
            }
        } else {
            baseResult.setStatus(false);
            baseResult.setMsg("用户不存在！");
        }
        return JsonUtils.toHashMap(baseResult);
    }

    //登录和注册判断用户名是否存在的方法，
    //根据不同的页面返回不同的提示信息
    @ResponseBody
    @RequestMapping("/checkUser")
    public HashMap<String, Object> checkUser(String userName, Integer checkType) {
        BaseResult baseResult = new BaseResult();
        User user = userService.getUserByName(userName);
        if (user != null) {
            if (checkType == Constants.CHECK_EXIST) {
                baseResult.setMsg("用户存在");
                baseResult.setStatus(true);
            } else if (checkType == Constants.CHECK_REPEAT) {
                baseResult.setMsg("用户名已经存在");
                baseResult.setStatus(false);
            }
        } else {
            if (checkType == Constants.CHECK_EXIST) {
                baseResult.setMsg("用户不存在");
                baseResult.setStatus(false);
            } else if (checkType == Constants.CHECK_REPEAT) {
                baseResult.setMsg("用户名未注册");
                baseResult.setStatus(true);
            }

        }
        return JsonUtils.toHashMap(baseResult);
    }



}
