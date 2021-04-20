package com.example.tc.model.entities;

import com.example.tc.model.enums.Zone;

public class Endpoint {
    private Zone source;
    private Zone destination;

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
}
