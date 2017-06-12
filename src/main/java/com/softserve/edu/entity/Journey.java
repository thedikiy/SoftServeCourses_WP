package com.softserve.edu.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Entity
public class Journey {
    @Id
    @GeneratedValue
    @Column(name = "JOURNEY_ID")
    private int journeyID;
    @Column(name = "LEAVING_DATE")
    private Date leavingDate;
    @Column(name = "ARRIVING_DATE")
    private Date arrivingDate;
    @ManyToOne
    @JoinColumn(name = "BUS_ID")
    private Bus bus;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DRIVER_ID")
    private Driver driver;

    @ManyToMany()
    @JoinTable(name = "JOURNEYS_PASSENGERS",joinColumns = @JoinColumn(name =
            "PASSENGERS"),inverseJoinColumns = @JoinColumn(name = "JOURNEYS"))
    private Set<Passenger> passengers;

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    public int getJourneyID() {
        return journeyID;
    }

    public void setJourneyID(int journeyID) {
        this.journeyID = journeyID;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Date getLeavingDate() {
        return leavingDate;
    }

    public void setLeavingDate(Date leavingDate) {
        this.leavingDate = leavingDate;
    }

    public Date getArrivingDate() {
        return arrivingDate;
    }

    public void setArrivingDate(Date arrivingDate) {
        this.arrivingDate = arrivingDate;
    }

}
