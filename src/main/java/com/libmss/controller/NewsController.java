package com.libmss.controller;

import com.libmss.model.News;
import com.libmss.model.PageModel;
import com.libmss.model.ResponseModel;
import com.libmss.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
@RequestMapping("/news")
public class NewsController {


    @Autowired
    NewsService newsService;

    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseModel<News> list(PageModel pageModel, News news) {
        return newsService.list(pageModel, news);
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseModel<News> add( News news) {
        news.setTime(new Date());
        return newsService.add(news);
    }

}
