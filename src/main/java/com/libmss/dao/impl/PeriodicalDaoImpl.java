package com.libmss.dao.impl;

import com.libmss.dao.PeriodicalDao;
import com.libmss.model.PageModel;
import com.libmss.model.Periodical;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component

public class PeriodicalDaoImpl extends BaseDaoImpl<Periodical> implements PeriodicalDao {
    public PeriodicalDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
        selectSql.append("select * from periodical where 1=1");
        countSql.append("select count(*) from periodical where 1=1");
    }
}
