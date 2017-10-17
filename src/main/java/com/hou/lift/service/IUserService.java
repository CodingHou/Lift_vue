package com.hou.lift.service;

import com.hou.lift.model.User;

/**
 * Created by houchao on 2017/1/9.
 */

public interface IUserService {
     User findUserById(int id);
     void addUser(User user);
     User getUserByName(String name);
}
