package com.libmss.dao;

import com.libmss.model.News;
import com.libmss.model.PageModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface NewsDao {
    public int add(News news);
    public int update(News news);
    public List<News> lsit(PageModel pageModel, News news);
    public long count(News news);
}
