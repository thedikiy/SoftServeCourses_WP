package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.UserDAO;
import com.softserve.edu.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class UserDAOImpl extends ElementDAOImpl<User> implements UserDAO {
    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        super(User.class, sessionFactory);
    }


    @Transactional
    public User findUserByUsername(String username) {
        List<User> uList = findByName(
                User.class.getSimpleName(), "username", username);
        if (uList == null || uList.size() == 0) {
            return null;
        }
        return uList.get(0);
    }
}
