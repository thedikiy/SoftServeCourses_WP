package com.softserve.edu.dao;

import com.softserve.edu.entity.Driver;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Repository
public class DriverDAO extends ElementDAOImpl<Driver>{
    public DriverDAO(Class<Driver> elementClass) {
        super(elementClass);
    }
}
