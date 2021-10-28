package com.mk.mybatis.controller;


import com.mk.mybatis.entity.Users;
import com.mk.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Desc TODO
 * @Author zhxy
 * @Date 2021/10/27 16:58
 * @Version V1.0
 **/


@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @RequestMapping("/list")
    public List<Users> queryAll(){
        return userService.findAll();
    }


    @RequestMapping("")
    public List<Users> queryByIds(List<String> ids){

    }




}
