package com.softserve.edu;

import com.softserve.edu.dao.BusDAO;
import com.softserve.edu.dao.DriverDAO;
import com.softserve.edu.entity.Bus;
import com.softserve.edu.entity.Journey;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.internal.SessionFactoryServiceRegistryBuilderImpl;
import org.hibernate.service.spi.SessionFactoryServiceRegistryBuilder;

import javax.imageio.spi.ServiceRegistry;
import java.util.HashSet;
import java.util.Set;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Bus bus = new Bus();
        bus.setBus_model("Big_bus");
        bus.setRegistrationNumber("1234");
        Set<Journey> journeys = new HashSet<Journey>();
        Journey journey = new Journey();
        journey.setBus(bus);
        journeys.add(journey);
        bus.setJourneys(journeys);
        new BusDAO().addElement(bus);
        System.out.println(new BusDAO().getElementByID(1));
    }
}
