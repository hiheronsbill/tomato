package com.mk.security.springsecuritydemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping("index")
    @ResponseBody
    public String index() {
        return "success";
    }


    @ResponseBody
    @GetMapping("no_author")
    public String noAuthor() {
        return "no_author";
    }


    @ResponseBody
    @GetMapping("/vip1")
    @PreAuthorize("hasAuthority('vip1')")
    public String vip1(){
        return "vip1";
    }

    @ResponseBody
    @GetMapping("/vip2")
    @PreAuthorize("hasAuthority('vip2')")
    public String vip2(){
        return "vip2";
    }

    @ResponseBody
    @GetMapping("/vip5")
    @PreAuthorize("hasAuthority('vip5')")
    public String vip5(){
        return "vip5";
    }
}
