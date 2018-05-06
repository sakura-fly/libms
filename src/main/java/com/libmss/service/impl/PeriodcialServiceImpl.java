package com.libmss.service.impl;

import com.libmss.dao.BaseDao;
import com.libmss.dao.PeriodicalDao;
import com.libmss.model.Periodical;
import com.libmss.service.PeriodicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PeriodcialServiceImpl extends BaseServiceImpl<Periodical>  implements PeriodicalService {


    public PeriodcialServiceImpl(PeriodicalDao periodicalDao) {
        super(periodicalDao);
        // sys
    }
}
