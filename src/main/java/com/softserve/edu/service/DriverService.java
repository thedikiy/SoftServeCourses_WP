package com.softserve.edu.service;

import com.softserve.edu.entity.Driver;
import org.springframework.stereotype.Service;

@Service
public class DriverService extends AbstractService{
    public DriverService() {
        super(Driver.class);
    }
}
