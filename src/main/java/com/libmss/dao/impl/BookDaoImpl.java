package com.libmss.dao.impl;

import com.libmss.dao.BookDao;
import com.libmss.model.Book;
import com.libmss.model.PageModel;

import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public int add(Book book) {
        return 0;
    }

    @Override
    public int update(Book book) {
        return 0;
    }

    @Override
    public List<Book> list(PageModel pageModel, Book book) {
        List<Book> l = new ArrayList<>();
        l.add(new Book("浮生物语",66.66,"娑罗双树","中国致公出版社","2015年7月第一版",66));
        l.add(new Book("浮生物语",66.66,"娑罗双树","中国致公出版社","2015年7月第一版",66));
        l.add(new Book("浮生物语",66.66,"娑罗双树","中国致公出版社","2015年7月第一版",66));
        l.add(new Book("浮生物语",66.66,"娑罗双树","中国致公出版社","2015年7月第一版",66));
        l.add(new Book("浮生物语",66.66,"娑罗双树","中国致公出版社","2015年7月第一版",66));
        l.add(new Book("浮生物语",66.66,"娑罗双树","中国致公出版社","2015年7月第一版",66));
        l.add(new Book("浮生物语",66.66,"娑罗双树","中国致公出版社","2015年7月第一版",66));

        return l;
    }

    @Override
    public long count(Book book) {

        return 7;
    }
}
