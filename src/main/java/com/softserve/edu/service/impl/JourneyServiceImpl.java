package com.softserve.edu.service.impl;

import com.softserve.edu.dao.JourneyDAO;
import com.softserve.edu.entity.Journey;
import com.softserve.edu.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JourneyServiceImpl extends AbstractCRUDService<Journey> implements JourneyService {

    @Autowired
    public JourneyServiceImpl(JourneyDAO journeyDAO) {
        super(journeyDAO);
    }

}
