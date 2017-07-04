package com.softserve.edu.entity;

import com.softserve.edu.validator.ValidPhone;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "DRIVER")
public class Driver {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY)
    @Column(name = "DRIVER_ID")
    private int driverID;
    @Column(name = "DRIVER_NAME")
    @Size(min = 1, max = 30, message = "{validation.error.name.is.empty}")
    private String driverName;
    @Column(name = "DRIVER_SURNAME")
    @Size(min = 1, max = 30, message = "{validation.error.surname.is.empty}")
    private String driverSurname;
    @Column(name = "PHONE_NUMBER")
    @ValidPhone(message = "{phone.validation.error.invalid.phone}")
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
