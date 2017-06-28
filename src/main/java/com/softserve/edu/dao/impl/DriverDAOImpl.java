package com.softserve.edu.dao.impl;

import com.softserve.edu.entity.Driver;
import org.springframework.stereotype.Repository;

@Repository
public class DriverDAOImpl extends ElementDAOImpl<Driver>{
    public DriverDAOImpl() {
        super(Driver.class);
    }
}
