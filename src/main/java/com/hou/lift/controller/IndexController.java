package com.hou.lift.controller;

import com.hou.lift.model.User;
import com.hou.lift.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;


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
    @RequestMapping("/signUp")
    public String signUp(User user, ModelMap modelMap,String repPwd) {
        userService.addUser(user);
        return "/main";
    }

    //登录
    @RequestMapping("signIn")
    public String signIn(User user, ModelMap modelMap) {
        user = userService.getUserByName(user.getUserName());
        if (user != null) {
            return "/main";
        }
        modelMap.addAttribute("message", "该用户不存在！");
        return "/index";
    }





}
