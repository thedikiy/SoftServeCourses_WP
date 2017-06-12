package com.softserve.edu.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Set;

public class Driver {
    @Id
    @GeneratedValue
    private int driverID;
    private String driverName;
    private String driverSurname;
    private String phoneNumber;
    private Date licanceExpire;
    private Set<Journey> journeys;

    public Set<Journey> getJourneys() {
        return journeys;
    }

    public void setJourneys(Set<Journey> journeys) {
        this.journeys = journeys;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverSurname() {
        return driverSurname;
    }

    public void setDriverSurname(String driverSurname) {
        this.driverSurname = driverSurname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getLicanceExpire() {
        return licanceExpire;
    }

    public void setLicanceExpire(Date licanceExpire) {
        this.licanceExpire = licanceExpire;
    }
}
