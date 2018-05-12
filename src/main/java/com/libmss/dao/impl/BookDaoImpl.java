package com.libmss.dao.impl;

import com.libmss.dao.BookDao;
import com.libmss.model.Book;
import com.libmss.model.PageModel;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao {
    public BookDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        selectSql.append("select * from book where 1=1");
        countSql.append("select count(*) from book where 1=1");
    }
}
