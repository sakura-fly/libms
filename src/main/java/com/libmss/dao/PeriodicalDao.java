package com.libmss.dao;

import com.libmss.model.Periodical;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component

public interface PeriodicalDao {
    public int add(Periodical periodical);
    public int update(Periodical periodical);
    public ArrayList<Periodical> list(int page, int limit, Periodical periodical);
    public long count(Periodical periodical);
}
