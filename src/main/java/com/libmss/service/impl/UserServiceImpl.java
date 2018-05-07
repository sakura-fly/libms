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


    public UserServiceImpl(UserDao userDaoImpl) {
        super(userDaoImpl);
    }


    @Override
    public ResponseModel<User> findById(int id) {
        ResponseModel<User> rm = new ResponseModel<User>();
        return rm;
    }

    @Override
    public ResponseModel<User> login(User user) {
        ResponseModel<User> rm = new ResponseModel<User>();
        return rm;
    }

    @Override
    public ResponseModel<User> regist(User user) {
        ResponseModel<User> rm = new ResponseModel<User>();
        int r = dao.add(user);
        rm.setCode(r);
        // rm.setMsg();
        return rm;
    }
}
