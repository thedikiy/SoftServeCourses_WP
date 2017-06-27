package com.softserve.edu.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Driver implements IEntity {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    @Column(name = "DRIVER_ID")
    private int driverID;
    @Column(name = "DRIVER_NAME")
    private String driverName;
    @Column(name = "DRIVER_SURNAME")
    private String driverSurname;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "LICENCE_EXPIRE")
    @Temporal(TemporalType.DATE)
    private Date licenceExpire;
    @OneToMany(mappedBy = "driver", fetch = FetchType.EAGER)
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

    public Date getLicenceExpire() {
        return licenceExpire;
    }

    public void setLicenceExpire(Date licanceExpire) {
        this.licenceExpire = licanceExpire;
    }
}
