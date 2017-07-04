package com.softserve.edu.service.impl;

import com.softserve.edu.dao.DriverDAO;
import com.softserve.edu.entity.Driver;
import com.softserve.edu.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl extends AbstractCRUDService<Driver> implements DriverService {

    @Autowired
    public DriverServiceImpl(DriverDAO driverDAO) {
        super(driverDAO);
    }
}
