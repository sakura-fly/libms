package com.libmss.controller;

import com.libmss.dao.PeriodicalDao;
import com.libmss.model.Book;
import com.libmss.model.PageModel;
import com.libmss.model.Periodical;
import com.libmss.model.ResponseModel;
import com.libmss.service.BookService;
import com.libmss.service.PeriodicalService;
import com.libmss.service.impl.BookServiceImpl;
import com.libmss.service.impl.PeriodcialServiceImpl;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;

@Controller
@RequestMapping("/periodical")
public class PeriodicalController {


    @Autowired
    PeriodcialServiceImpl periodicalService;

//    @Autowired
//    PeriodicalDao periodicalDao;


    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public  ResponseModel<Periodical> list(/*PrintWriter out, */PageModel pageModel, Periodical periodical){
//        periodicalService.setDao(periodicalDao);
        ResponseModel<Periodical> r = periodicalService.list(pageModel, periodical);
//        out.print(JSONObject.fromObject(r));
        return r;
    }

}
