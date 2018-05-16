package com.libmss.dao.impl;

import com.libmss.dao.NewsDao;
import com.libmss.model.News;
import com.libmss.model.PageModel;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Component
public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao {

    public NewsDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        selectSql.append(" select * from news b, user_tb u where u.id=b.uid");
        countSql.append("select count(*) from news where 1=1");
    }
}
