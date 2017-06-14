package com.softserve.edu.dal.dao;

import com.softserve.edu.entity.Driver;
import org.springframework.stereotype.Repository;

@Repository
public class DriverDAO extends ElementDAOImpl<Driver>{
    public DriverDAO() {
        super(Driver.class);
    }
}
