package com.libmss.dao.impl;

import com.libmss.dao.BaseDao;
import com.libmss.model.PageModel;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class BaseDaoImpl<T> implements BaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;
    protected String selectSql;


    protected abstract void setSelectSql(T t);
    protected abstract SQLQuery setHibernateSetParameter(SQLQuery query,T t);

    public BaseDaoImpl() {
        session = sessionFactory.openSession();
    }

    @Override
    public int add(T t) {
        int stat = 1;
        try {
            Serializable s = session.save(t);
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
        SQLQuery sql = session.createSQLQuery(selectSql);
        sql.addEntity(t.getClass());
        sql = setHibernateSetParameter(sql,t);
        return sql.list();
        // Criteria cr = session.createCriteria(t.getClass());
        //
    }

    @Override
    public long count(T t) {
        return 0;
    }
}
