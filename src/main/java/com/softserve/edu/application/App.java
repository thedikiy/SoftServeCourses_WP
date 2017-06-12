package com.softserve.edu.application;

import com.softserve.edu.dao.BusDAO;
import com.softserve.edu.entity.Bus;
import com.softserve.edu.entity.Driver;
import com.softserve.edu.entity.Journey;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class App
{
    public static void main( String[] args )
    {
        Bus bus = new Bus();
        bus.setBus_model("Big_bus");
        bus.setRegistrationNumber("12345");
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
        new BusDAO().addElement(bus);
        System.out.println("-----------");
        System.out.println(new BusDAO().getElementByID(1).getBus_model());
    }
}
