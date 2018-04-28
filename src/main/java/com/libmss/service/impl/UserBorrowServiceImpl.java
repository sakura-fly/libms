package com.libmss.service.impl;

import com.libmss.dao.BaseDao;
import com.libmss.dao.UserBorrowDao;
import com.libmss.model.UserBorrow;
import com.libmss.service.UserBorrowService;
import org.springframework.stereotype.Service;

@Service
public class UserBorrowServiceImpl extends BaseServiceImpl<UserBorrow> implements UserBorrowService {

    public UserBorrowServiceImpl(UserBorrowDao userBorrowDao) {
        super(userBorrowDao);
    }
}
