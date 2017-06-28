package com.softserve.edu.dao.impl;

import com.softserve.edu.entity.Journey;
import org.springframework.stereotype.Repository;

@Repository
public class JourneyDAOImpl extends ElementDAOImpl<Journey> {
    public JourneyDAOImpl() {
        super(Journey.class);
    }
}
