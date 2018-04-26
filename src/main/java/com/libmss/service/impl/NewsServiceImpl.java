package com.libmss.service.impl;

import com.libmss.dao.BaseDao;
import com.libmss.dao.NewsDao;
import com.libmss.model.News;
import com.libmss.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NewsServiceImpl extends BaseServiceImpl<News> implements NewsService {


    public NewsServiceImpl(NewsDao newsDao) {
        super(newsDao);
    }
}
