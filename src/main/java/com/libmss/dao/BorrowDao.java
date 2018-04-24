package com.libmss.dao;

import com.libmss.model.Borrow;

import java.util.List;

public interface BorrowDao {
    public int add (Borrow borrow);
    public int update(Borrow borrow);
    public List<Borrow> list(int page, int limit, Borrow borrow);
}
