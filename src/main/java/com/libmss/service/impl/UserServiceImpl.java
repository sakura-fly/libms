package com.libmss.service.impl;

import com.libmss.dao.BaseDao;
import com.libmss.dao.BookDao;
import com.libmss.dao.UserDao;
import com.libmss.model.Book;
import com.libmss.model.ResponseModel;
import com.libmss.model.User;
import com.libmss.service.BaseService;
import com.libmss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {


    public UserServiceImpl(UserDao userDao) {
        super(userDao);
    }


    @Override
    public ResponseModel<Book> findById(int id) {
        ResponseModel<Book> rm = new ResponseModel<Book>();

        return rm;
    }

    @Override
    public ResponseModel<Book> login(Book book) {
        ResponseModel<Book> rm = new ResponseModel<Book>();
        return rm;
    }

}
