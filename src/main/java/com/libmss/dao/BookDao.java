package com.libmss.dao;

import com.libmss.model.Book;
import com.libmss.model.PageModel;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public interface BookDao {
    public int add (Book book);
    public int update(Book book);
    public List<Book> list (PageModel pageModel, Book book);
    public long count(Book book);
}
