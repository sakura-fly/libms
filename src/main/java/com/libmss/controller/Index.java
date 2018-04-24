package com.libmss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.PrintWriter;

@Controller
public class Index {


    @RequestMapping("/test")
    public void test(PrintWriter out){
        out.print("666");
//        sys
    }

}
