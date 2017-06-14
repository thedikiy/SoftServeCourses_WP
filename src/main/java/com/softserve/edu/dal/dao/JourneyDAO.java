package com.softserve.edu.dal.dao;

import com.softserve.edu.entity.Journey;
import org.springframework.stereotype.Repository;

@Repository
public class JourneyDAO extends ElementDAOImpl<Journey> {
    public JourneyDAO() {
        super(Journey.class);
    }
}
