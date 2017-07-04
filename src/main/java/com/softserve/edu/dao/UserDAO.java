package com.softserve.edu.dao;

import com.softserve.edu.entity.User;

public interface UserDAO extends ElementDAO<User> {
    User findUserByUsername(String name);
}
