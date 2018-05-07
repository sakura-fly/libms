package com.libmss.dao.impl;

import com.libmss.dao.UserDao;
import com.libmss.model.User;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        selectSql.append("select * from user_tb where 1=1");

    }

    @Override
    public List<User> login(User user) {
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        StringBuffer selectSqla = new StringBuffer();
        List l = new ArrayList();
        try {
            selectSqla.append(" and uname = :uname");
            selectSqla.append(" and pwd = :pwd");
            SQLQuery q = session.createSQLQuery(selectSql.toString() + selectSqla.toString());
            q.addEntity(User.class);
            q.setParameter("uname", user.getUname());
            q.setParameter("pwd", user.getPwd());
            l = q.list();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            tx.commit();
            session.close();
        }
        return l;
    }

}
