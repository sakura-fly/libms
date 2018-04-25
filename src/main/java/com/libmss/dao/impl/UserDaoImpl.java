package com.libmss.dao.impl;

import com.libmss.dao.UserDao;
import com.libmss.model.PageModel;
import com.libmss.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public int add(User user) {
        return 0;
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public List<User> list(PageModel pageModel, User user) {
        List<User> l = new ArrayList<>();
        // tring uname, String pwd, Date ctime, String phone
        l.add(new User("zry","周蓉渊",new Date(),"18888888888"));
        l.add(new User("zry","周蓉渊",new Date(),"18888888888"));
        l.add(new User("zry","周蓉渊",new Date(),"18888888888"));
        l.add(new User("zry","周蓉渊",new Date(),"18888888888"));
        l.add(new User("zry","周蓉渊",new Date(),"18888888888"));
        l.add(new User("zry","周蓉渊",new Date(),"18888888888"));

        return null;
    }

    @Override
    public long count(User user) {
        return 6;
    }
}
