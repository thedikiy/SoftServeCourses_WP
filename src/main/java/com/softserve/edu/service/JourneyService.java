package com.softserve.edu.service;

import com.softserve.edu.entity.Journey;
import org.springframework.stereotype.Service;

@Service
public class JourneyService extends AbstractService <Journey>{
    public JourneyService() {
        super(Journey.class);
    }
}
