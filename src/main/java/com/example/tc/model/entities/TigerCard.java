package com.example.tc.model.entities;

import java.util.Objects;

public class TigerCard {
    private Traveller traveller;

    public Traveller getTraveller() {
        return traveller;
    }

    public void setTraveller(Traveller traveller) {
        this.traveller = traveller;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TigerCard tigerCard = (TigerCard) o;
        return Objects.equals(traveller, tigerCard.traveller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(traveller);
    }
}
