package com.libmss.service.impl;

import com.libmss.dao.BorrowDao;
import com.libmss.model.Borrow;
import com.libmss.service.BookService;
import com.libmss.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;

public class BorrowServiceImpl extends BaseServiceImpl<Borrow> implements BorrowService {

    @Autowired
    BorrowDao borrowDao;

    @Override
    protected void setDao() {
        dao = borrowDao;
    }
}
