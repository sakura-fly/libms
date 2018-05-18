package com.libmss.dao.impl;

import com.libmss.dao.BaseDao;
import com.libmss.model.PageModel;
import com.libmss.model.User;
import com.libmss.util.SqlUtil;
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
    protected StringBuffer countSql = new StringBuffer();
    protected StringBuffer updateSql = new StringBuffer();
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
            String s = SqlUtil.sqlUpdateSet(t);
            SQLQuery sql = session.createSQLQuery(updateSql + s);
            System.out.println("sqlStr======" + updateSql + s);
            sql = SqlUtil.createSqlIs(t,sql);
            // session.update(t);
            sql.executeUpdate();
            tx.commit();
            session.close();
            stat = 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stat;
    }

    @Override
    public List<T> list(PageModel pageModel, T t) {


        List<T> res = new ArrayList<>();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            String s = SqlUtil.sqlFindLike(t);
            SQLQuery sql = session.createSQLQuery(selectSql.toString() + s + " limit :skip , :limit");
            sql.addEntity(t.getClass());
            sql = SqlUtil.createSqlLike(t,sql);
            sql.setParameter("skip",pageModel.getSkip());
            sql.setParameter("limit",pageModel.getLimit());
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
        // 获取数量
        long count = 0;
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            String s = SqlUtil.sqlFindLike(t);
            SQLQuery sql = session.createSQLQuery(countSql.toString() + s);
            sql = SqlUtil.createSqlLike(t,sql);
            count = ((Number) sql.list().get(0)).longValue();
        }catch (Exception e){
            e.printStackTrace();
        }
        tx.commit();
        session.close();
        return count;
    }
}
