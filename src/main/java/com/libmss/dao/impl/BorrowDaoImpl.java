package com.libmss.dao.impl;

import com.libmss.dao.BorrowDao;
import com.libmss.model.Borrow;
import com.libmss.model.PageModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BorrowDaoImpl implements BorrowDao {

    @Override
    public int add(Borrow borrow) {
        return 0;
    }

    @Override
    public int update(Borrow borrow) {
        return 0;
    }

    @Override
    public List<Borrow> list(PageModel pageModel, Borrow borrow) {
        List<Borrow> l = new ArrayList<>();

        l.add(new Borrow(1,1,1,new Date(),new Date(),1));
        l.add(new Borrow(1,1,1,new Date(),new Date(),1));
        l.add(new Borrow(1,1,1,new Date(),new Date(),1));
        l.add(new Borrow(1,1,1,new Date(),new Date(),1));
        l.add(new Borrow(1,1,1,new Date(),new Date(),1));
        l.add(new Borrow(1,1,1,new Date(),new Date(),1));

        return l;
    }

    @Override
    public long count(Borrow borrow) {
        return 6;
    }
}
