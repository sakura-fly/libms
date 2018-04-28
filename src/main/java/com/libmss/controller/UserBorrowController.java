package com.libmss.controller;

import com.libmss.model.PageModel;
import com.libmss.model.ResponseModel;
import com.libmss.model.UserBorrow;
import com.libmss.service.impl.UserBorrowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ub")
public class UserBorrowController {

    @Autowired
    UserBorrowServiceImpl userBorrowService;

    @RequestMapping(value = "list", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel<UserBorrow> list(PageModel page, UserBorrow borrow){
        return userBorrowService.list(page,borrow);
    }

}
