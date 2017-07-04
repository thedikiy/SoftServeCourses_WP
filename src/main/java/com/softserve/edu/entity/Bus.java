package com.softserve.edu.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "BUS")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BUS_ID")
    private int busID;
    @Column(name = "BUS_MODEL")
    @Size(min = 1, max = 100, message = "{validation.error.surname.is.empty}")
    private String busModel;
    @Column(name = "REGISTRATION_NUMBER")
    private String registrationNumber;
    @Column(name = "LAST_TI")
    @Temporal(TemporalType.DATE)
    private Date lastTI;
    @Column(name = "NEXT_TI")
    @Temporal(TemporalType.DATE)
    private Date nextTI;
    @OneToMany(mappedBy = "bus", fetch = FetchType.EAGER)
    private Set<Journey> journeys;


    public int getBusID() {
        return busID;
    }

    public void setBusID(int busID) {
        this.busID = busID;
    }

    public Set<Journey> getJourneys() {
        return journeys;
    }

    public void setJourneys(Set<Journey> journeys) {
        this.journeys = journeys;
    }

    public String getBusModel() {
        return busModel;
    }

    public void setBusModel(String bus_model) {
        this.busModel = bus_model;
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
