package com.wyl.eshop.controller;

import com.wyl.eshop.bean.DepartMent;
import com.wyl.eshop.service.DepartMentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author :wyl
 * @Date :2019/8/23 10:40
 * @Version 1.0 :
 * @Description :
 */
@RestController
public class DeptController {
    @Autowired
    private DepartMentService departMentService;

    @GetMapping("/dept/{id}")
    public DepartMent getDept(@PathVariable("id") Integer id){
        DepartMent departMent = departMentService.getDept(id);
        return departMent;
    }
}
