package com.libmss.dao;

import com.libmss.model.PageModel;

import java.util.List;

public interface BaseDao<T> {
    public int add (T t);
    public int update(T t);
    public List<T> list (PageModel pageModel, T t);
    public long count(T t);
}
