package com.libmss.dao;

import com.libmss.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface UserDao {
    public int add (User user);
    public int update(User user);
    public List<User> list (int page, int limit,User user);
    public long count(User user);
}
