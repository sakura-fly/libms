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
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

    protected Session session;
    protected StringBuffer selectSql = new StringBuffer();
    protected SessionFactory sessionFactory;


    public BaseDaoImpl(SessionFactory sessionFactory) {
        // session = sessionFactory.openSession();
        this.sessionFactory = sessionFactory;
    }

    @Override
    public int add(T t) {
        int stat = -1;
        session = sessionFactory.openSession();
        Transaction tt = session.beginTransaction();
        try {
            // session.

            Serializable s = session.save(t);

            tt.commit();
            session.close();
            // session.close()
            stat = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stat;
    }

    @Override
    public int update(T t) {
        int stat = -1;
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.update(t);
            tx.commit();
            session.close();
            stat = 1;
        } catch (Exception e) {
            session.update(t);
            tx.commit();
            e.printStackTrace();
        }
        return stat;
    }

    @Override
    public List<T> list(PageModel pageModel, T t) {


        List<T> res = new ArrayList<>();
        Class<?> c = t.getClass();
        Field[] uf = c.getDeclaredFields();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        StringBuffer selectSqla = new StringBuffer();
        try {
            for (int i = 0; i < uf.length; i++) {
                Field f = uf[i];
                f.setAccessible(true);
                String name = f.getName();
                try {
                    Object val = f.get(t);
                    String type = f.getType().toString();

                    if (type.endsWith("int") || type.endsWith("Integer")) {
                        if ((int) val != -2233) {
                            selectSqla.append(" and ").append(name).append(" like :").append(name);
                        }
                    } else if (type.endsWith("double") || type.endsWith("Double")) {
                        if ((double) val != -2233) {
                            selectSqla.append(" and ").append(name).append(" like :").append(name);
                        }
                    } else {
                        if (val != null && !val.toString().isEmpty()) {
                            selectSqla.append(" and ").append(name).append(" like :").append(name);
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
            SQLQuery sql = session.createSQLQuery(selectSql.toString() + selectSqla.toString());
            sql.addEntity(t.getClass());
            for (int i = 0; i < uf.length; i++) {
                Field f = uf[i];
                f.setAccessible(true);
                String name = f.getName();
                try {
                    Object val = f.get(t);
                    String type = f.getType().toString();
                    if (type.endsWith("int") || type.endsWith("Integer")) {
                        if ((int) val != -2233) {
                            // selectSql.append(" and " + name + " = :" + name);
                            sql.setParameter(name, "%" + val + "%");
                        }
                    }  else if (type.endsWith("double") || type.endsWith("Double")) {
                        if ((double) val != -2233) {
                            sql.setParameter(name, "%" + val + "%");
                        }
                    } else {
                        if (val != null && !val.toString().isEmpty()) {
                            sql.setParameter(name, "%" + val + "%");
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
            res = sql.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        session.close();
        return res;
    }

    @Override
    public long count(T t) {
        return 0;
    }
}
