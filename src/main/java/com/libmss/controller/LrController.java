package com.libmss.controller;

import com.libmss.model.ResponseModel;
import com.libmss.model.User;
import com.libmss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class LrController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel regist(User user){
        user.setCtime(new Date());
       return  userService.regist(user);
    }

    @RequestMapping(value = "/sigin", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel sigin(User user){
        // user.setCtime(new Date());
       return  userService.login(user);
    }



}
