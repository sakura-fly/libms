package com.libmss.dao;

import com.libmss.model.Borrow;
import com.libmss.model.PageModel;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public interface BorrowDao {
    public int add (Borrow borrow);
    public int update(Borrow borrow);
    public List<Borrow> list(PageModel pageModel, Borrow borrow);
    public long count(Borrow borrow);
}
