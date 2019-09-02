package com.wyl.eshop.service;

import com.wyl.eshop.bean.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author :wyl
 * @Date :2019/7/25 11:28
 * @Version 1.0 :
 * @Description :
 */
@Component
public interface UserService {

    public User getUserById(int id);

    public User checkLogin(User user);
}
