package com.libmss.dao;

import com.libmss.model.Periodical;

import java.util.ArrayList;

public interface PeriodicalDao {
    public int add(Periodical periodical);
    public int update(Periodical periodical);
    public ArrayList<Periodical> list(int page, int limit, Periodical periodical);
}
