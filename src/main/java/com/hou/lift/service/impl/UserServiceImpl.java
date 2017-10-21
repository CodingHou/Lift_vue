package com.hou.lift.service.impl;

import com.hou.lift.dao.UserMapper;
import com.hou.lift.model.User;
import com.hou.lift.model.UserExample;
import com.hou.lift.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by houchao on 2017/1/9.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;


    public User findUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getUserByName(String name) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(name);
        List<User> userList = userMapper.selectByExample(example);
        if (userList != null&&userList.size()>0) {
            return userList.get(0);
        }
        return null;

    }
}
