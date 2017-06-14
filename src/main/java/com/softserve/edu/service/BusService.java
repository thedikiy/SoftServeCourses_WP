package com.softserve.edu.service;

import com.softserve.edu.entity.Bus;
import org.springframework.stereotype.Service;

@Service
public class BusService extends AbstractService {
    public BusService() {
        super(Bus.class);
    }
}
