package com.libmss.service;

import com.libmss.model.Book;
import com.libmss.model.PageModel;
import com.libmss.model.ResponseModel;
import com.libmss.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserService extends BaseService<User>{

    public ResponseModel<User> findById(int id);
    public ResponseModel<User> login(User user);
    public ResponseModel<User> regist(User user);
}
