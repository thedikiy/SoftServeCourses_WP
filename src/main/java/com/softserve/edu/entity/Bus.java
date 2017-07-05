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
    @Size(min = 1, max = 10, message = "{validation.error.bus.reg.number.is.empty}")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bus bus = (Bus) o;

        if (busID != bus.busID) return false;
        if (!busModel.equals(bus.busModel)) return false;
        if (!registrationNumber.equals(bus.registrationNumber)) return false;
        if (lastTI != null ? !lastTI.equals(bus.lastTI) : bus.lastTI != null)
            return false;
        if (nextTI != null ? !nextTI.equals(bus.nextTI) : bus.nextTI != null)
            return false;
        return journeys != null ? journeys.equals(bus.journeys) : bus.journeys == null;
    }

    @Override
    public int hashCode() {
        int result = busID;
        result = 31 * result + busModel.hashCode();
        result = 31 * result + registrationNumber.hashCode();
        result = 31 * result + (lastTI != null ? lastTI.hashCode() : 0);
        result = 31 * result + (nextTI != null ? nextTI.hashCode() : 0);
        result = 31 * result + (journeys != null ? journeys.hashCode() : 0);
        return result;
    }
}
