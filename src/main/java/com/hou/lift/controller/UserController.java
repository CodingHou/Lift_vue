package com.hou.lift.controller;

import com.hou.lift.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by houchao on 2016/12/29.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        System.out.println("=========test=========");
        return "index";
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public String getUser() {
        return "userInfo";
    }


}
