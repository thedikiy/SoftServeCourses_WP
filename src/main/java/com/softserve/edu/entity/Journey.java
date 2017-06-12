package com.softserve.edu.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@Entity
public class Journey {
    @Id
    @GeneratedValue
    private int journeyID;
    @ManyToOne
    private Bus bus;
    @ManyToMany
    private Set<Journey> journeys;

    public Set<Journey> getJourneys() {
        return journeys;
    }

    public void setJourneys(Set<Journey> journeys) {
        this.journeys = journeys;
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

    private Date leavingDate;
    private Date arrivingDate;
}
