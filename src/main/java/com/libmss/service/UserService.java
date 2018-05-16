package com.libmss.service;

import com.libmss.model.ResponseModel;
import com.libmss.model.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public interface UserService extends BaseService<User>{

    public ResponseModel<User> findById(int id);
    public ResponseModel<User> login(User user, HttpSession session);
    public ResponseModel<User> regist(User user);
}
