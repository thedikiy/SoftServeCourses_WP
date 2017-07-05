package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.BusDAO;
import com.softserve.edu.entity.Bus;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BusDAOImpl extends ElementDAOImpl<Bus> implements BusDAO {
    @Autowired
    public BusDAOImpl(SessionFactory sessionFactory) {
        super(Bus.class, sessionFactory);
    }
}
