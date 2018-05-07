package com.libmss.service.impl;

import com.libmss.dao.BaseDao;
import com.libmss.dao.BookDao;
import com.libmss.dao.UserDao;
import com.libmss.model.Book;
import com.libmss.model.PageModel;
import com.libmss.model.ResponseModel;
import com.libmss.model.User;
import com.libmss.service.BaseService;
import com.libmss.service.UserService;
import com.libmss.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    UserDao userDao;

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
        user.setPwd(MD5.md5(user.getPwd()));

        ResponseModel<User> rm = new ResponseModel<User>();
        PageModel pm = new PageModel();
        List<User> r = userDao.login(user);
        if (r.size() == 0){
            rm.setMsg("用户名或密码错误");
            rm.setCode(-1);
        } else {
            rm.setCode(1);
            User rr = r.get(0);
            rr.setPwd("");
            rm.setModel(rr);
        }
        return rm;
    }

    @Override
    public ResponseModel<User> regist(User user) {
        user.setPwd(MD5.md5(user.getPwd()));
        ResponseModel<User> rm = new ResponseModel<User>();
        int r = dao.add(user);
        rm.setCode(r);
        // rm.setMsg();
        return rm;
    }
}
