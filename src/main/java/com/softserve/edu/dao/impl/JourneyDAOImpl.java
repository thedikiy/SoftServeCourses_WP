package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.JourneyDAO;
import com.softserve.edu.entity.Journey;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JourneyDAOImpl extends ElementDAOImpl<Journey> implements JourneyDAO {
    @Autowired
    public JourneyDAOImpl(SessionFactory sessionFactory) {
        super(Journey.class, sessionFactory);
    }

}
