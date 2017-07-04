package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.UserDAO;
import com.softserve.edu.entity.User;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAOImpl extends ElementDAOImpl<User> implements UserDAO {
    public UserDAOImpl() {
        super(User.class);
    }

    public User findUserByUsername(String username) {
        User user = null;
        return null;
    }
}
