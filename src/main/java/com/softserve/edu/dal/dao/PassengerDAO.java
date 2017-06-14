package com.softserve.edu.dal.dao;

import com.softserve.edu.entity.Passenger;
import org.springframework.stereotype.Repository;

@Repository
public class PassengerDAO extends ElementDAOImpl<Passenger> {
    public PassengerDAO() {
        super(Passenger.class);
    }
}
