package com.libmss.dao;

import com.libmss.model.News;

import java.util.List;

public interface NewsDao {
    public int add(News news);
    public int update(News news);
    public List<News> lsit(int page, int limit, News news);
}
