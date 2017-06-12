package com.softserve.edu.dao;

import com.softserve.edu.entity.Passenger;
import org.springframework.stereotype.Repository;

@Repository
public class PassengerDAO extends ElementDAOImpl<Passenger> {
    public PassengerDAO(Class<Passenger> elementClass) {
        super(elementClass);
    }
}
