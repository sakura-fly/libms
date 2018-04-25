package com.libmss.dao.impl;

import com.libmss.dao.PeriodicalDao;
import com.libmss.model.Periodical;

import java.util.ArrayList;

public class PeriodicalDaoImpl implements PeriodicalDao {
    @Override
    public int add(Periodical periodical) {
        return 0;
    }

    @Override
    public int update(Periodical periodical) {
        return 0;
    }

    @Override
    public ArrayList<Periodical> list(int page, int limit, Periodical periodical) {

        ArrayList<Periodical> l = new ArrayList<>();
        // String name, double price, String author, String publisher, String edition
        l.add(new Periodical("格言",5,"","黑龙江出版社","2第五期",23));
        l.add(new Periodical("格言",5,"","黑龙江出版社","2第五期",23));
        l.add(new Periodical("格言",5,"","黑龙江出版社","2第五期",23));
        l.add(new Periodical("格言",5,"","黑龙江出版社","2第五期",23));
        l.add(new Periodical("格言",5,"","黑龙江出版社","2第五期",23));
        l.add(new Periodical("格言",5,"","黑龙江出版社","2第五期",23));

        return l;
    }

    @Override
    public long count(Periodical periodical) {
        return 6;
    }
}
