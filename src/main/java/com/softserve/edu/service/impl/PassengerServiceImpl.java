package com.softserve.edu.service.impl;

import com.softserve.edu.dao.PassengerDAO;
import com.softserve.edu.entity.Passenger;
import com.softserve.edu.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerServiceImpl extends AbstractCRUDService<Passenger> implements PassengerService {
    @Autowired
    public PassengerServiceImpl(PassengerDAO passengerDAO) {
        super(passengerDAO);
    }
}
