package com.libmss.dao;

import com.libmss.model.PageModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BaseDao<T> {
    public int add (T t);
    public int update(T t);
    public List<T> list (PageModel pageModel, T t);
    public long count(T t);
}
