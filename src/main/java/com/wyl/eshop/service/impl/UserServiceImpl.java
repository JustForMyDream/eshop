package com.wyl.eshop.service.impl;

import com.wyl.eshop.bean.User;
import com.wyl.eshop.dao.UserMapper;
import com.wyl.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author :wyl
 * @Date :2019/7/25 11:28
 * @Version 1.0 :
 * @Description :
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User checkLogin(User user) {
        return userMapper.checkLogin(user);
    }
}
