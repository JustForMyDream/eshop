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
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public RestResponse test(HttpServletRequest request){
        String id = request.getParameter("id");
        User user = userService.getUserById(Integer.parseInt(id));
        Map<String,Object> map = new HashMap<>();
        map.put("user",user);
        return RestResponse.success(map);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RestResponse login(@RequestParam(value = "username") String username,
                              @RequestParam(value = "password") String password){
        System.out.println("username:"+username+"password:"+password);
//        Map<String,Object> map = new HashMap<>();
//        User user1 = userService.checkLogin(user);
//        map.put("data","");
        return RestResponse.success();
    }


}
