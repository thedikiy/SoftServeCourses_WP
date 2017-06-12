package com.softserve.edu.dao;

import com.softserve.edu.entity.Bus;
import org.springframework.stereotype.Repository;

@Repository
public class BusDAO extends ElementDAOImpl<Bus>{
    public BusDAO() {
        super(Bus.class);
    }
}
