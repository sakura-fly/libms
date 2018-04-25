package com.libmss.dao;

import com.libmss.model.Borrow;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public interface BorrowDao {
    public int add (Borrow borrow);
    public int update(Borrow borrow);
    public List<Borrow> list(int page, int limit, Borrow borrow);
    public long count(Borrow borrow);
}
