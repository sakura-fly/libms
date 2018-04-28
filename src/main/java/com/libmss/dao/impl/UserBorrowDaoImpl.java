package com.libmss.dao.impl;

import com.libmss.dao.UserBorrowDao;
import com.libmss.model.PageModel;
import com.libmss.model.UserBorrow;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserBorrowDaoImpl implements UserBorrowDao {
    @Override
    public int add(UserBorrow userBorrow) {
        return 0;
    }

    @Override
    public int update(UserBorrow userBorrow) {
        return 0;
    }

    @Override
    public List<UserBorrow> list(PageModel pageModel, UserBorrow userBorrow) {
        List<UserBorrow> l = new ArrayList<>();
        // String bookName, Date bTime, Date rTime, Date rrTime
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            l.add(new UserBorrow("恋练有词",sdf.parse("2018-04-26"),sdf.parse("2018-05-26"),sdf.parse("2018-04-16")));
            l.add(new UserBorrow("恋练有词",sdf.parse("2018-04-26"),sdf.parse("2018-04-27"),null));
            l.add(new UserBorrow("恋练有词",sdf.parse("2018-04-26"),sdf.parse("2018-05-26"),sdf.parse("2018-04-16")));
            l.add(new UserBorrow("恋练有词",sdf.parse("2018-04-26"),sdf.parse("2018-05-26"),null));
            l.add(new UserBorrow("恋练有词",sdf.parse("2018-04-26"),sdf.parse("2018-05-26"),sdf.parse("2018-04-16")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return l;
    }

    @Override
    public long count(UserBorrow userBorrow) {
        return 4;
    }
}
