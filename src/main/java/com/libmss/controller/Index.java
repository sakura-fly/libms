package com.libmss.controller;

import com.libmss.model.User;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.PrintWriter;
import java.util.Date;

@Controller
public class Index {

    @RequestMapping("/")
    public String index(){
        return "redirect:admin/adminconsole.html";
    }


    @RequestMapping("/test")
    public void test(PrintWriter out){
        User u = new User("666","233","",new Date(),"123");
        JSONObject o = JSONObject.fromObject(u);
        out.print(o.toString());
//        sys
    }

}
