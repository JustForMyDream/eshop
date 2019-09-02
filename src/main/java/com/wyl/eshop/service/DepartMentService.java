package com.wyl.eshop.service;

import com.wyl.eshop.bean.DepartMent;
import org.springframework.stereotype.Component;

/**
 * @Author :wyl
 * @Date :2019/8/23 10:05
 * @Version 1.0 :
 * @Description :
 */
public interface DepartMentService {

    DepartMent getDept(int id);
}
