package com.softserve.edu.entity;

import com.softserve.edu.validator.ValidPhone;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "PASSENGER")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PASSENGER_ID")
    private int passengerID;
    @Size(min = 1, max = 30, message = "{validation.error.name.is.empty}")
    @Column(name = "PASSENGER_NAME")
    private String passengerName;
    @Column(name = "PASSENGER_SURNAME")
    @Size(min = 1, max = 30, message = "{validation.error.surname.is.empty}")
    private String passengerSurname;
    @Column(name = "PHONE_NUMBER")
    @ValidPhone(message = "{phone.validation.error.invalid.phone}")
    private String phoneNumber;
    @ManyToMany(mappedBy = "passengers", fetch = FetchType.EAGER)
    private Set<Journey> journeys;
    @ManyToOne()
    @JoinColumn(name = "USER_ID")
    private User owner;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerSurname() {
        return passengerSurname;
    }

    public void setPassengerSurname(String passengerSurname) {
        this.passengerSurname = passengerSurname;
    }

    public Set<Journey> getJourneys() {
        return journeys;
    }

    public void setJourneys(Set<Journey> journeys) {
        this.journeys = journeys;
    }
}
