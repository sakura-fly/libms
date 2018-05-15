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

import java.util.Date;

@Controller
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    BorrowService borrowService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel<Borrow> add(Borrow borrow) {
        borrow.setStat(1);
        return borrowService.add(borrow);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel<Borrow> list(PageModel pageModel, Borrow borrow) {
        return borrowService.list(pageModel, borrow);
    }

    @RequestMapping(value = "/return", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel<Borrow> returnBook(int id, Integer bid) {
        Borrow borrow = new Borrow();
        borrow.setId(id);
        // borrow.setBid(bid);
        borrow.setStat(1);
        borrow.setRetime(new Date());
        return borrowService.update(borrow);
    }


}
