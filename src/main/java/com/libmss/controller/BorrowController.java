package com.libmss.controller;

import com.libmss.model.Book;
import com.libmss.model.Borrow;
import com.libmss.model.PageModel;
import com.libmss.model.ResponseModel;
import com.libmss.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    BorrowService borrowService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel<Borrow> add(Borrow borrow) {
        return borrowService.add(borrow);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResponseModel<Borrow> list(PageModel pageModel, Borrow borrow) {
        return borrowService.list(pageModel, borrow);
    }


}
