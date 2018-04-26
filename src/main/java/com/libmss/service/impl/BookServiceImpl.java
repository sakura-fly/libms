package com.libmss.service.impl;

import com.libmss.dao.BaseDao;
import com.libmss.dao.BookDao;
import com.libmss.model.Book;
import com.libmss.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class BookServiceImpl extends BaseServiceImpl<Book> implements BookService  {


    public BookServiceImpl(BookDao bookDao) {
        super(bookDao);
    }
}
