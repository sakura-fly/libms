package com.libmss.dao;

import com.libmss.model.Book;

import java.util.List;

public interface BookDao {
    public int add (Book book);
    public int update(Book book);
    public List<Book> list (int page, int limit, Book book);
}
