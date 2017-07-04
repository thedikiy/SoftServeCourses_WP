package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.DriverDAO;
import com.softserve.edu.entity.Driver;
import org.springframework.stereotype.Repository;

@Repository
public class DriverDAOImpl extends ElementDAOImpl<Driver> implements DriverDAO {
    public DriverDAOImpl() {
        super(Driver.class);
    }
}
