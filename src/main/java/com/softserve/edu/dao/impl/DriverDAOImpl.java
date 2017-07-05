package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.DriverDAO;
import com.softserve.edu.entity.Driver;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DriverDAOImpl extends ElementDAOImpl<Driver> implements DriverDAO {
    @Autowired
    public DriverDAOImpl(SessionFactory sessionFactory) {
        super(Driver.class, sessionFactory);
    }
}
