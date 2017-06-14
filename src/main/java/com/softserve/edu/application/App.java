package com.softserve.edu.application;

import com.softserve.edu.dal.dao.BusDAO;
import com.softserve.edu.entity.Bus;
import com.softserve.edu.entity.Driver;
import com.softserve.edu.entity.Journey;
import com.softserve.edu.service.BusService;
import com.softserve.edu.service.DriverService;
import com.softserve.edu.service.JourneyService;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class App
{
    public static void main( String[] args )
    {
        Bus bus = new Bus();
        bus.setBusModel("Big_bus");
        bus.setRegistrationNumber("1534615");
        new BusService().addElement(bus);
        Driver driver = new Driver();
        driver.setDriverName("Vitya23");
        driver.setDriverSurname("asd32");
        driver.setPhoneNumber("afss4321fad");
        driver.setLicenceExpire(new Date());
        new DriverService().addElement(driver);
        Set<Journey> journeys = new HashSet<Journey>();
        Journey journey = new Journey();
        journey.setFromPlace("Dnepr");
        journey.setDestination("nahui");
        journey.setBus(bus);
        journeys.add(journey);
        journey.setDriver(driver);
        new JourneyService().addElement(journey);
        bus.setJourneys(journeys);
        driver.setJourneys(journeys);
        new BusService().updateElement(bus);
        new DriverService().updateElement(driver);
/*
        Set<Journey> journeys = new HashSet<Journey>();
        Journey journey = new Journey();
        journey.setBus(bus);
        journeys.add(journey);
        bus.setJourneys(journeys);
        Driver driver = new Driver();
        driver.setDriverName("Vitya");
        driver.setDriverSurname("asd");
        driver.setJourneys(journeys);
        driver.setPhoneNumber("afssfad");
        driver.setLicenceExpire(new Date());
        journey.setDriver(driver);

        System.out.println("-----------");
        System.out.println(new BusDAO().getElementByID(1).getBus_model());*/
    }
}
