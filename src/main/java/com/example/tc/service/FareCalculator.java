package com.example.tc.service;

import com.example.tc.constant.Globals;
import com.example.tc.exception.TigerCardException;
import com.example.tc.model.entities.FareEnquiry;
import com.example.tc.model.entities.PeakDemand;
import com.example.tc.model.enums.Zone;

import java.time.LocalDateTime;
import java.util.Optional;

public class FareCalculator {
    public double getFare(Zone source, Zone destination, LocalDateTime localDateTime) {
        final Optional<PeakDemand> peakDemandOptional = Globals.PEAK_HOURS_CONF_LIST.stream()
                .filter(peakDemand -> peakDemand.getDayOfWeeks().contains(localDateTime.getDayOfWeek()))
                .filter(peakDemand -> peakDemand.getHourFrom() >= localDateTime.getHour()
                        && peakDemand.getMinFrom() >= localDateTime.getMinute())
                .filter(peakDemand -> peakDemand.getHourTo() <= localDateTime.getHour() &&
                        peakDemand.getMinTo() <= localDateTime.getMinute())
                .findAny();
        final Optional<FareEnquiry> optionalFareEnquiry = Globals.FARE_ENQUIRY_LIST.stream()
                .filter(fareEnquiry -> fareEnquiry.getSource().equals(source) &&
                        fareEnquiry.getDestination().equals(destination))
                .findAny();
        if (peakDemandOptional.isPresent()) {
            if (optionalFareEnquiry.isPresent()) {
                return optionalFareEnquiry.get().getPeakHourFare();
            }
            throw new TigerCardException("Fare Not Configured");
        } else {
            if (optionalFareEnquiry.isPresent()) {
                return optionalFareEnquiry.get().getOffPeakHourFare();
            }
            throw new TigerCardException("Fare Not Configured");
        }
    }
}
