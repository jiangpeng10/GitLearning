package com.ljp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private UserinfoService userinfoService;

    @RequestMapping(value = "dologin",method = RequestMethod.POST)
    public Object dologin(){

        return null;
    }
}
