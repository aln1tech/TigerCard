package com.example.tc.model.entities;

import com.example.tc.model.enums.Zone;

import java.time.LocalDate;
import java.util.Objects;

public class DailyCapTrx {
    private Traveller traveller;
    private LocalDate travelDate;
    private Zone source;
    private Zone destination;
    private double capLimit;
    private double totalFare;

    public DailyCapTrx() {
    }

    public DailyCapTrx(Traveller traveller, LocalDate travelDate) {
        this.traveller = traveller;
        this.travelDate = travelDate;
    }

    public double getTotalFare() {
        return totalFare;
    }

    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }

    public double getCapLimit() {
        return capLimit;
    }

    public void setCapLimit(double capLimit) {
        this.capLimit = capLimit;
    }

    public Traveller getTraveller() {
        return traveller;
    }

    public void setTraveller(Traveller traveller) {
        this.traveller = traveller;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate date) {
        this.travelDate = date;
    }

    public Zone getSource() {
        return source;
    }

    public void setSource(Zone source) {
        this.source = source;
    }

    public Zone getDestination() {
        return destination;
    }

    public void setDestination(Zone destination) {
        this.destination = destination;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyCapTrx that = (DailyCapTrx) o;
        return traveller.equals(that.traveller) &&
                travelDate.equals(that.travelDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(traveller, travelDate);
    }
}
