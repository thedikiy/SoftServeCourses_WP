package com.softserve.edu.service;

import com.softserve.edu.dao.impl.DriverDAOImpl;
import com.softserve.edu.entity.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService extends AbstractCRUDService <Driver> {

    @Autowired
    public DriverService(DriverDAOImpl driverDAO) {
        super(driverDAO);
    }
}
