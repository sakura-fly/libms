package com.libmss.service.impl;

import com.libmss.dao.BookDao;
import com.libmss.model.Book;
import com.libmss.model.PageModel;
import com.libmss.model.ResponseModel;
import com.libmss.model.User;
import com.libmss.service.BookService;
import com.libmss.util.StringValue;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bd;


    @Override
    public ResponseModel<Book> add(Book book) {
        int stat = bd.add(book);
        ResponseModel rm = new ResponseModel();
        rm.setCode(stat);
        rm.setMsg(stat == 0 ? StringValue.RESPONSE_SUCCES : StringValue.RESPONSE_FAILD);
        return rm;
    }

    @Override
    public ResponseModel<Book> update(Book book) {
        ResponseModel rm = new ResponseModel();
        int stat = bd.update(book);
        rm.setCode(stat);
        rm.setMsg(stat == 0 ? StringValue.RESPONSE_SUCCES : StringValue.RESPONSE_FAILD);
        return rm;
    }

    @Override
    public ResponseModel<Book> list(PageModel page, Book book) {
        ResponseModel rm = new ResponseModel();
        List<Book> lsit = bd.list(page, book);
        rm.setMsg(lsit.isEmpty() ? StringValue.LIST_FAILD : "");
        rm.setCode(lsit.isEmpty() ? -1 : 0);
        rm.setData(lsit);
        rm.setCount(bd.count(book));
        return rm;
    }

    @Override
    public ResponseModel<Book> findById(int id) {
        ResponseModel rm = new ResponseModel();

        return rm;
    }

    @Override
    public ResponseModel<Book> login(Book book) {
        ResponseModel rm = new ResponseModel();
        return rm;
    }
}
