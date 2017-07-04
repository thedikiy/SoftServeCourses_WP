package com.softserve.edu.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "PASSENGER")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PASSENGER_ID")
    private Integer passengerID;
    @Size(min = 1, max = 30, message = "{validation.error.name.is.empty}")
    @Column(name = "PASSENGER_NAME")
    private String passengerName;
    @Column(name = "PASSENGER_SURNAME")
    @Size(min = 1, max = 30, message = "{validation.error.surname.is.empty}")
    private String passengerSurname;
    @ManyToMany(mappedBy = "passengers", fetch = FetchType.EAGER)
    private Set<Journey> journeys;

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
