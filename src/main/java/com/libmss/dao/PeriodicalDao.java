package com.libmss.dao;

import com.libmss.model.PageModel;
import com.libmss.model.Periodical;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component

public interface PeriodicalDao {
    public int add(Periodical periodical);
    public int update(Periodical periodical);
    public ArrayList<Periodical> list(PageModel pageModel, Periodical periodical);
    public long count(Periodical periodical);
}
