package com.libmss.dao.impl;

import com.libmss.dao.BorrowDao;
import com.libmss.model.Borrow;
import com.libmss.model.PageModel;
import com.libmss.util.SqlUtil;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component
public class BorrowDaoImpl extends BaseDaoImpl<Borrow> implements BorrowDao {
    public BorrowDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        selectSql.append("select w.*,b.* from borrow w, book b where b.id = w.bid");
        countSql.append("select count(*) from borrow where 1=1");
    }

    @Override
    public List<Borrow> list(PageModel pageModel, Borrow borrow) {
        List<Borrow> res = new ArrayList<>();
        session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try {
            String s = SqlUtil.sqlFindIs(borrow);

            SQLQuery sql = session.createSQLQuery(selectSql.toString() +s);

            sql.addEntity(borrow.getClass());
            sql = SqlUtil.createSqlIs(borrow,sql);
            res = sql.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        session.close();
        return res;
    }
}
