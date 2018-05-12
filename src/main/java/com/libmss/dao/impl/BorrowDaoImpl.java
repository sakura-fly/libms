package com.libmss.dao.impl;

import com.libmss.dao.BorrowDao;
import com.libmss.model.Borrow;
import com.libmss.model.PageModel;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component
public class BorrowDaoImpl extends BaseDaoImpl<Borrow> implements BorrowDao {
    public BorrowDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        selectSql.append("select * from borrow where 1=1");
        countSql.append("select count(*) from borrow where 1=1");
    }
}
