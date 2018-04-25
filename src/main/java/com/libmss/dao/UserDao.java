package com.libmss.dao;

import com.libmss.model.PageModel;
import com.libmss.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface UserDao {
    public int add (User user);
    public int update(User user);
    public List<User> list (PageModel pageModel, User user);
    public long count(User user);
}
