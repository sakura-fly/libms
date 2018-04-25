package com.libmss.service.impl;

import com.libmss.dao.NewsDao;
import com.libmss.model.News;
import com.libmss.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;

public class NewsServiceImpl extends BaseServiceImpl<News> implements NewsService {

    @Autowired
    NewsDao newsDao;

    @Override
    protected void setDao() {
        dao = newsDao;
    }
}
