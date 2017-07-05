package com.softserve.edu.service.impl;

import com.softserve.edu.dao.JourneyDAO;
import com.softserve.edu.entity.Journey;
import com.softserve.edu.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class JourneyServiceImpl extends AbstractCRUDService<Journey> implements JourneyService {

    JourneyDAO journeyDAO;

    @Autowired
    public JourneyServiceImpl(JourneyDAO journeyDAO) {
        super(journeyDAO);
        this.journeyDAO = journeyDAO;
    }
}
