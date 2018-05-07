package com.libmss.dao;

import com.libmss.model.PageModel;
import com.libmss.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface UserDao extends BaseDao<User>{
    public List<User> login(User user);
}
