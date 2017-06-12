package com.softserve.edu.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Bus {
    @Id
    @GeneratedValue
    @Column(name = "BUS_ID")
    private int busID;
    @Column(name = "BUS_MODEL")
    private String bus_model;
    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;
    @Column(name = "LAST_TI")
    private Date lastTI;
    @Column(name = "NEXT_TI")
    private Date nextTI;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "bus")
    private Set<Journey> journeys;

    public Set<Journey> getJourneys() {
        return journeys;
    }

    public void setJourneys(Set<Journey> journeys) {
        this.journeys = journeys;
    }

    public int getBusID() {
        return busID;
    }

    public void setBusID(int busID) {
        this.busID = busID;
    }

    public String getBus_model() {
        return bus_model;
    }

    public void setBus_model(String bus_model) {
        this.bus_model = bus_model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Date getLastTI() {
        return lastTI;
    }

    public void setLastTI(Date lastTI) {
        this.lastTI = lastTI;
    }

    public Date getNextTI() {
        return nextTI;
    }

    public void setNextTI(Date nextTI) {
        this.nextTI = nextTI;
    }
}
