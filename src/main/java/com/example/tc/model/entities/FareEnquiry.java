package com.example.tc.model.entities;

import com.example.tc.model.enums.Zone;

public class FareEnquiry {
    private Zone source;
    private Zone destination;
    private Double peakHourFare;
    private Double offPeakHourFare;

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

    public Double getPeakHourFare() {
        return peakHourFare;
    }

    public void setPeakHourFare(Double peakHourFare) {
        this.peakHourFare = peakHourFare;
    }

    public Double getOffPeakHourFare() {
        return offPeakHourFare;
    }

    public void setOffPeakHourFare(Double offPeakHourFare) {
        this.offPeakHourFare = offPeakHourFare;
    }
}
