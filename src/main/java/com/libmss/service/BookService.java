package com.libmss.service;

import com.libmss.model.Book;
import com.libmss.model.PageModel;
import com.libmss.model.ResponseModel;
import com.libmss.model.User;

import java.util.List;

public interface BookService {
    public ResponseModel<Book> add(Book book);
    public ResponseModel<Book> update(Book book);
    public ResponseModel<Book> list(PageModel page, Book book);
    public ResponseModel<Book> findById(int id);
    public ResponseModel<Book> login(Book book);
}
