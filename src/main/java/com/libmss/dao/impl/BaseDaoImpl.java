package com.libmss.dao.impl;

import com.libmss.dao.BaseDao;
import com.libmss.model.PageModel;
import com.libmss.model.User;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

    private Session session;
    protected StringBuffer selectSql = new StringBuffer();



    public BaseDaoImpl(SessionFactory sessionFactory) {
        session = sessionFactory.openSession();
    }

    @Override
    public int add(T t) {
        int stat = -1;
        try {
            // session.
            Serializable s = session.save(t);
            // Transaction tt = session.beginTransaction();
            // tt.commit();
            stat = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stat;
    }

    @Override
    public int update(T t) {
        return 0;
    }

    @Override
    public List<T> list(PageModel pageModel, T t) {


        // Class<User> uc = User.class;
        Class<?> c = t.getClass();
        Field[] uf = c.getDeclaredFields();
        for (int i = 0; i < uf.length; i++) {
            Field f = uf[i];
            f.setAccessible(true);
            String name = f.getName();
            try {
                Object val = f.get(t);
                String type = f.getType().toString();
                if (type.endsWith( "int" ) || type.endsWith( "Integer" )){
                    if ((int)val != -2233){
                        selectSql.append(" and " + name + " = :" + name);
                    }
                } else {
                    if (val != null){
                        selectSql.append(" and " + name + " = :" + name);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        SQLQuery sql = session.createSQLQuery(selectSql.toString());
        sql.addEntity(t.getClass());
        for (int i = 0; i < uf.length; i++) {
            Field f = uf[i];
            f.setAccessible(true);
            String name = f.getName();
            try {
                Object val = f.get(t);
                String type = f.getType().toString();
                if (type.endsWith( "int" ) || type.endsWith( "Integer" )){
                    if ((int)val != -2233){
                        // selectSql.append(" and " + name + " = :" + name);
                        sql.setParameter(name,val);
                    }
                } else {
                    if (val != null){
                        sql.setParameter(name,val);
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        // sql = setHibernatequery(sql,t);
        return sql.list();
        // Criteria cr = session.createCriteria(t.getClass());
        //
    }

    @Override
    public long count(T t) {
        return 0;
    }
}
