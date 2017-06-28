package com.softserve.edu.dao.impl;

import com.softserve.edu.entity.Bus;
import org.springframework.stereotype.Repository;

@Repository
public class BusDAOImpl extends ElementDAOImpl<Bus> {
    public BusDAOImpl() {
        super(Bus.class);
    }
}
