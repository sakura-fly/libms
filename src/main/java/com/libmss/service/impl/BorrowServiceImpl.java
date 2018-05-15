package com.libmss.service.impl;

import com.libmss.dao.BaseDao;
import com.libmss.dao.BorrowDao;
import com.libmss.model.Borrow;
import com.libmss.model.ResponseModel;
import com.libmss.service.BookService;
import com.libmss.service.BorrowService;
import com.libmss.util.StringValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class BorrowServiceImpl extends BaseServiceImpl<Borrow> implements BorrowService {


    public BorrowServiceImpl(BorrowDao borrowDao) {
        super(borrowDao);
    }

    @Override
    public ResponseModel<Borrow> add(Borrow borrow) {
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DATE, borrow.getDays());
        borrow.setOp(new Date());
        borrow.setEd(calendar.getTime());
        borrow.setStat(1);
        int stat = dao.add(borrow);
        ResponseModel<Borrow> rm = new ResponseModel<>();
        rm.setCode(stat);
        rm.setMsg(stat == 1 ? StringValue.RESPONSE_SUCCES : StringValue.RESPONSE_FAILD);
        return rm;
    }
}
