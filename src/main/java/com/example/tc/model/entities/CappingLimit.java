package com.example.tc.model.entities;

import com.example.tc.model.enums.Cap;
import com.example.tc.model.enums.Zone;

import java.util.Objects;

public class CappingLimit {
    private Zone source;
    private Zone destination;
    private Cap cap;
    private double fare;

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

    public Cap getCap() {
        return cap;
    }

    public void setCap(Cap cap) {
        this.cap = cap;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CappingLimit that = (CappingLimit) o;
        return source == that.source &&
                destination == that.destination &&
                cap == that.cap;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, cap);
    }
}
