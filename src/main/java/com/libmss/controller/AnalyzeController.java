package com.libmss.controller;

import com.libmss.model.Analyze;
import com.libmss.model.Book;
import com.libmss.model.ResponseModel;
import com.libmss.service.AnalyzeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.Response;

@Controller
@RequestMapping("/analyze")
public class AnalyzeController {


    @Autowired
    AnalyzeService analyzeService;

    @RequestMapping(value = "/borrow", method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel<Analyze> list(String tName, @RequestParam(defaultValue = "-2233") int uid){
        return analyzeService.borrowNum(tName,uid);
    }

}
