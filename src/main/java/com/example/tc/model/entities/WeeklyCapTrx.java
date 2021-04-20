package com.example.tc.model.entities;

import com.example.tc.model.enums.Zone;

import java.util.Objects;

public class WeeklyCapTrx {
    private Traveller traveller;
    private int weekNo;
    private Zone source;
    private Zone destination;
    private double capLimit;
    private double totalFare;

    public WeeklyCapTrx() {
    }

    public WeeklyCapTrx(Traveller traveller, int weekNo) {
        this.traveller = traveller;
        this.weekNo = weekNo;
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

    public int getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(int weekNo) {
        this.weekNo = weekNo;
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
        WeeklyCapTrx that = (WeeklyCapTrx) o;
        return Objects.equals(traveller, that.traveller) &&
                Objects.equals(weekNo, that.weekNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(traveller, weekNo);
    }
}
