package com.libmss.controller;

import com.libmss.model.PageModel;
import com.libmss.model.ResponseModel;
import com.libmss.model.User;
import com.libmss.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserServiceImpl userService;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseModel<User> list(PageModel pageModel, User user) {
        return userService.list(pageModel, user);
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseModel<User> update(User user) {
        return userService.update(user);
    }

}
