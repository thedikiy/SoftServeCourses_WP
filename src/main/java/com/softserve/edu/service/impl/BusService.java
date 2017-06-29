package com.softserve.edu.service.impl;

import com.softserve.edu.dao.impl.BusDAOImpl;
import com.softserve.edu.entity.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusService extends AbstractCRUDService <Bus> {

    @Autowired
    public BusService(BusDAOImpl busDAO) {
        super(busDAO);
    }
}
