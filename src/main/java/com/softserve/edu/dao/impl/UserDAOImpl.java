package com.softserve.edu.dao.impl;

import com.softserve.edu.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;



@Repository
public class UserDAOImpl extends ElementDAOImpl<User> {
    public UserDAOImpl() {
        super(User.class);
    }

    public User findUserByUserName(String username) {
        return super.findUserByName(
                User.class.getSimpleName(),"username", username);
    }
}
