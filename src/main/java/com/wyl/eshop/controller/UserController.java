package com.wyl.eshop.controller;

import com.wyl.eshop.bean.User;
import com.wyl.eshop.common.RestResponse;
import com.wyl.eshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author :wyl
 * @Date :2019/7/25 10:58
 * @Version 1.0 :
 * @Description :
 */
@RestController("/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/test")
    public RestResponse test(HttpServletRequest request){
        String id = request.getParameter("id");
        User user = userService.getUserById(Integer.parseInt(id));
        Map<String,Object> map = new HashMap<>();
        map.put("user",user);
        return RestResponse.success(map);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RestResponse login(@RequestBody User user) {

        Map<String,Object> map = new HashMap<>();
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
        User checkUser = userService.checkLogin(user);
        if(checkUser != null){
            map.put("user",checkUser);
            return RestResponse.success(map);
        }else {
            return RestResponse.error(400,"fail");
        }
    }




}
