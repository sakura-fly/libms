package com.libmss.controller;

import com.libmss.model.PageModel;
import com.libmss.model.Periodical;
import com.libmss.model.ResponseModel;
import com.libmss.service.impl.PeriodcialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/periodical")
public class PeriodicalController {


    @Autowired
    PeriodcialServiceImpl periodicalService;


    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel<Periodical> list(PageModel pageModel, Periodical periodical) {
        return periodicalService.list(pageModel, periodical);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel<Periodical> add(Periodical periodical) {
        return periodicalService.add(periodical);
    }

}
