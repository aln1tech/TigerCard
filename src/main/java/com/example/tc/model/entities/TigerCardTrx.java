package com.example.tc.model.entities;

import com.example.tc.model.enums.Zone;

import java.time.LocalDateTime;

public class TigerCardTrx {
    private TigerCard card;
    private Zone source;
    private Zone destination;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double fare;

    public TigerCard getCard() {
        return card;
    }

    public void setCard(TigerCard tigerCard) {
        this.card = tigerCard;
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }
}
