package com.example.tc.model.entities;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class PeakDemand {
    private List<DayOfWeek> dayOfWeeks = new ArrayList<>();
    private int hourFrom;
    private int hourTo;
    private int minFrom;
    private int minTo;
    private List<Endpoint> endpoints = new ArrayList<>();

    public List<DayOfWeek> getDayOfWeeks() {
        return dayOfWeeks;
    }

    public void setDayOfWeeks(List<DayOfWeek> dayOfWeeks) {
        this.dayOfWeeks = dayOfWeeks;
    }

    public int getHourFrom() {
        return hourFrom;
    }

    public void setHourFrom(int hourFrom) {
        this.hourFrom = hourFrom;
    }

    public int getHourTo() {
        return hourTo;
    }

    public void setHourTo(int hourTo) {
        this.hourTo = hourTo;
    }

    public int getMinFrom() {
        return minFrom;
    }

    public void setMinFrom(int minFrom) {
        this.minFrom = minFrom;
    }

    public int getMinTo() {
        return minTo;
    }

    public void setMinTo(int minTo) {
        this.minTo = minTo;
    }

    public List<Endpoint> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(List<Endpoint> endpoints) {
        this.endpoints = endpoints;
    }
}
