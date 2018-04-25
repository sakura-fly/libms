package com.libmss.service.impl;

import com.libmss.dao.BookDao;
import com.libmss.model.Book;
import com.libmss.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceImpl extends BaseServiceImpl<Book> implements BookService  {

    @Autowired
    BookDao bookDao;

    @Override
    protected void setDao() {
        dao = bookDao;
    }
}
