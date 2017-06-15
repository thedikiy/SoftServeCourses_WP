package com.softserve.edu.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Journey implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "journ_seq_gen")
    @SequenceGenerator(name = "journ_seq_gen", sequenceName = "journ_seq")
    @Column(name = "JOURNEY_ID")
    private int journeyID;
    @Column(name = "LEAVING_DATE")
    private Date leavingDate;
    @Column(name = "ARRIVING_DATE")
    private Date arrivingDate;
    @Column(name = "FROM_PLACE")
    private String fromPlace;
    @Column(name = "DESTINATION")
    private String destination;

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String from) {
        this.fromPlace = from;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @ManyToOne
    @JoinColumn(name = "BUS_ID")
    private Bus bus;

    @ManyToOne()
    @JoinColumn(name = "DRIVER_ID")
    private Driver driver;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "JOURNEYS_PASSENGERS",joinColumns = @JoinColumn(name =
            "PASSENGERS"),inverseJoinColumns = @JoinColumn(name = "JOURNEYS"))
    private Set<Passenger> passengers = new HashSet<Passenger>();

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
