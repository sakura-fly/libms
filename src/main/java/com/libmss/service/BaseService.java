package com.libmss.service;

import com.libmss.model.Book;
import com.libmss.model.PageModel;
import com.libmss.model.ResponseModel;
import org.springframework.stereotype.Component;

@Component
public interface BaseService<T> {
    public ResponseModel<T> add(T t);
    public ResponseModel<T> update(T t);
    public ResponseModel<T> list(PageModel page, T t);
}
