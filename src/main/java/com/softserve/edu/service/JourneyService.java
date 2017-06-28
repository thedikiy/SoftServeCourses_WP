package com.softserve.edu.service;

import com.softserve.edu.dao.impl.JourneyDAOImpl;
import com.softserve.edu.entity.Journey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JourneyService extends AbstractCRUDService<Journey> {

    @Autowired
    public JourneyService(JourneyDAOImpl journeyDAO) {
        super(journeyDAO);
    }
}
