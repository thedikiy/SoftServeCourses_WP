package com.softserve.edu.service;

import com.softserve.edu.dao.impl.PassengerDAOImpl;
import com.softserve.edu.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService extends AbstractCRUDService <Passenger> {
    @Autowired
    public PassengerService(PassengerDAOImpl passengerDAO) {
        super(passengerDAO);
    }
}
