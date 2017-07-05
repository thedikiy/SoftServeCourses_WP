package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.PassengerDAO;
import com.softserve.edu.entity.Passenger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PassengerDAOImpl extends ElementDAOImpl<Passenger> implements PassengerDAO {
    @Autowired
    public PassengerDAOImpl(SessionFactory sessionFactory) {
        super(Passenger.class, sessionFactory);
    }
}
