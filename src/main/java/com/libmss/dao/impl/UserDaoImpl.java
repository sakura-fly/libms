package com.libmss.dao.impl;

import com.libmss.dao.BaseDao;
import com.libmss.dao.UserDao;
import com.libmss.model.PageModel;
import com.libmss.model.User;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        selectSql.append("select * from user where 1=1");

    }






    // @Override
    // public int add(User user) {
    //     return 0;
    // }

    // @Override
    // public int update(User user) {
    //     return 0;
    // }
    //
    // @Override
    // public List<User> list(PageModel pageModel, User user) {
    //     List<User> l = new ArrayList<>();
    //     // tring uname, String pwd, Date ctime, String phone
    //     l.add(new User("zry","周蓉渊","",new Date(),"18888888888"));
    //     l.add(new User("zry","周蓉渊","",new Date(),"18888888888"));
    //     l.add(new User("zry","周蓉渊","",new Date(),"18888888888"));
    //     l.add(new User("zry","周蓉渊","",new Date(),"18888888888"));
    //     l.add(new User("zry","周蓉渊","",new Date(),"18888888888"));
    //     l.add(new User("zry","周蓉渊","",new Date(),"18888888888"));
    //
    //     return l;
    // }

    // @Override
    // public long count(User user) {
    //     return 6;
    // }
}
