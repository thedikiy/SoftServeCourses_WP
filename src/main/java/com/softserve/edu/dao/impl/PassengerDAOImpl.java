package com.softserve.edu.dao.impl;

import com.softserve.edu.entity.Passenger;
import org.springframework.stereotype.Repository;

@Repository
public class PassengerDAOImpl extends ElementDAOImpl<Passenger> {
    public PassengerDAOImpl() {
        super(Passenger.class);
    }
}
