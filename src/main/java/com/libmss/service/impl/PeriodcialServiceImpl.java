package com.libmss.service.impl;

import com.libmss.dao.PeriodicalDao;
import com.libmss.model.Periodical;
import com.libmss.service.PeriodicalService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jnlp.PersistenceService;

public class PeriodcialServiceImpl extends BaseServiceImpl<Periodical>  implements PeriodicalService {

    @Autowired
    PeriodicalDao periodicalDao;

    @Override
    protected void setDao() {
        dao = periodicalDao;
    }
}
