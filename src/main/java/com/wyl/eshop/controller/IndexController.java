package com.wyl.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author :wyl
 * @Date :2019/7/25 15:25
 * @Version 1.0 :
 * @Description :
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String doInit(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {

        return "index";
    }
}
