package com.wyl.eshop.service.impl;

import com.wyl.eshop.bean.DepartMent;
import com.wyl.eshop.dao.DepartMentMapper;
import com.wyl.eshop.service.DepartMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author :wyl
 * @Date :2019/8/23 10:05
 * @Version 1.0 :
 * @Description :
 */
@Service
public class DepartMentServiceImpl implements DepartMentService {

    @Autowired
    private DepartMentMapper departMentMapper;

    @Override
    @Cacheable(cacheNames = "dept")
    public DepartMent getDept(int id) {
        System.out.println("查询用户:"+id);
        return departMentMapper.getDept(id);
    }
}
