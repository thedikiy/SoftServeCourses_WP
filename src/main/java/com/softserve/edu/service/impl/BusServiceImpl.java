package com.softserve.edu.service.impl;

import com.softserve.edu.dao.BusDAO;
import com.softserve.edu.entity.Bus;
import com.softserve.edu.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusServiceImpl extends AbstractCRUDService<Bus> implements BusService {

    @Autowired
    public BusServiceImpl(BusDAO busDAO) {
        super(busDAO);
    }
}
