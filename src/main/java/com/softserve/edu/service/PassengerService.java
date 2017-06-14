package com.softserve.edu.service;

import com.softserve.edu.entity.Passenger;
import org.springframework.stereotype.Service;

@Service
public class PassengerService extends AbstractService {
    public PassengerService() {
        super(Passenger.class);
    }
}
