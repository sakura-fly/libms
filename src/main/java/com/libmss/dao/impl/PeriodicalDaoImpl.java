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
    }
    // @Override
    // public int add(Periodical periodical) {
    //     int stat = -1;
    //     try {
    //         dao
    //         stat = 1;
    //     } catch (Exception e){
    //         e.printStackTrace();
    //     }
    //     return stat;
    // }

    // @Override
    // public int update(Periodical periodical) {
    //     return 0;
    // }

    // @Override
    // public ArrayList<Periodical> list(PageModel pageModel, Periodical periodical) {
    //
    //     ArrayList<Periodical> l = new ArrayList<>();
    //     // String name, double price, String author, String publisher, String edition
    //     l.add(new Periodical("格言",5,"","黑龙江出版社","第五期",23));
    //     l.add(new Periodical("格言",5,"","黑龙江出版社","第五期",23));
    //     l.add(new Periodical("格言",5,"","黑龙江出版社","第五期",23));
    //     l.add(new Periodical("格言",5,"","黑龙江出版社","第五期",23));
    //     l.add(new Periodical("格言",5,"","黑龙江出版社","第五期",23));
    //     l.add(new Periodical("格言",5,"","黑龙江出版社","第五期",23));
    //
    //     return l;
    // }

    // @Override
    // public long count(Periodical periodical) {
    //     return 6;
    // }
}
