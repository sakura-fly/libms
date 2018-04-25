package com.libmss.service;

import com.libmss.model.Book;
import com.libmss.model.PageModel;
import com.libmss.model.ResponseModel;
import com.libmss.model.User;

import java.util.List;

public interface UserService {

    public ResponseModel<Book> findById(int id);
    public ResponseModel<Book> login(Book book);
}
