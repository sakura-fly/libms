package com.libmss.dao.impl;

import com.libmss.dao.NewsDao;
import com.libmss.model.News;
import com.libmss.model.PageModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsDaoImpl implements NewsDao {
    @Override
    public int add(News news) {
        return 0;
    }

    @Override
    public int update(News news) {
        return 0;
    }

    @Override
    public List<News> lsit(PageModel pageModel, News news) {
        List<News> l = new ArrayList<>();


        l.add(new News(1,"五一大酬宾","庆祝五一，全场五折", new Date(),new Date(),new Date()));
        l.add(new News(1,"五一大酬宾","庆祝五一，全场五折", new Date(),new Date(),new Date()));
        l.add(new News(1,"五一大酬宾","庆祝五一，全场五折", new Date(),new Date(),new Date()));
        l.add(new News(1,"五一大酬宾","庆祝五一，全场五折", new Date(),new Date(),new Date()));
        l.add(new News(1,"五一大酬宾","庆祝五一，全场五折", new Date(),new Date(),new Date()));
        l.add(new News(1,"五一大酬宾","庆祝五一，全场五折", new Date(),new Date(),new Date()));


        return l;
    }

    @Override
    public long count(News news) {
        return 6;
    }
}
