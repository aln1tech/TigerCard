package com.example.tc.constant;

import com.example.tc.model.entities.CappingLimit;
import com.example.tc.model.entities.Endpoint;
import com.example.tc.model.entities.FareEnquiry;
import com.example.tc.model.entities.PeakDemand;
import com.example.tc.model.enums.Cap;
import com.example.tc.model.enums.Zone;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Globals {
    public static final List<PeakDemand> PEAK_HOURS_CONF_LIST = new ArrayList<>();

    public static final List<FareEnquiry> FARE_ENQUIRY_LIST = new ArrayList<>();

    public static final List<CappingLimit> CAPPING_LIMIT_LIST = new ArrayList<>();

    public Globals() {

        CAPPING_LIMIT_LIST.add(new CappingLimit() {{
            setCap(Cap.DAILY);
            setSource(Zone.Zone1);
            setDestination(Zone.Zone2);
            setFare(120);
        }});

        CAPPING_LIMIT_LIST.add(new CappingLimit() {{
            setCap(Cap.DAILY);
            setSource(Zone.Zone2);
            setDestination(Zone.Zone1);
            setFare(120);
        }});

        CAPPING_LIMIT_LIST.add(new CappingLimit() {{
            setCap(Cap.DAILY);
            setSource(Zone.Zone1);
            setDestination(Zone.Zone1);
            setFare(100);
        }});

        CAPPING_LIMIT_LIST.add(new CappingLimit() {{
            setCap(Cap.DAILY);
            setSource(Zone.Zone2);
            setDestination(Zone.Zone2);
            setFare(100);
        }});


        CAPPING_LIMIT_LIST.add(new CappingLimit() {{
            setCap(Cap.WEEKLY);
            setSource(Zone.Zone1);
            setDestination(Zone.Zone2);
            setFare(600);
        }});

        CAPPING_LIMIT_LIST.add(new CappingLimit() {{
            setCap(Cap.WEEKLY);
            setSource(Zone.Zone2);
            setDestination(Zone.Zone1);
            setFare(600);
        }});

        CAPPING_LIMIT_LIST.add(new CappingLimit() {{
            setCap(Cap.WEEKLY);
            setSource(Zone.Zone1);
            setDestination(Zone.Zone1);
            setFare(500);
        }});

        CAPPING_LIMIT_LIST.add(new CappingLimit() {{
            setCap(Cap.WEEKLY);
            setSource(Zone.Zone2);
            setDestination(Zone.Zone2);
            setFare(400);
        }});

        FARE_ENQUIRY_LIST.add(new FareEnquiry() {{
            setSource(Zone.Zone1);
            setDestination(Zone.Zone1);
            setPeakHourFare(30d);
            setOffPeakHourFare(25d);
        }});

        FARE_ENQUIRY_LIST.add(new FareEnquiry() {{
            setSource(Zone.Zone2);
            setDestination(Zone.Zone2);
            setPeakHourFare(25d);
            setOffPeakHourFare(20d);
        }});

        FARE_ENQUIRY_LIST.add(new FareEnquiry() {{
            setSource(Zone.Zone1);
            setDestination(Zone.Zone2);
            setPeakHourFare(35d);
            setOffPeakHourFare(30d);
        }});

        FARE_ENQUIRY_LIST.add(new FareEnquiry() {{
            setSource(Zone.Zone2);
            setDestination(Zone.Zone1);
            setPeakHourFare(35d);
            setOffPeakHourFare(30d);
        }});

        PEAK_HOURS_CONF_LIST.add(new PeakDemand() {{
            getDayOfWeeks().add(DayOfWeek.MONDAY);
            getDayOfWeeks().add(DayOfWeek.TUESDAY);
            getDayOfWeeks().add(DayOfWeek.WEDNESDAY);
            getDayOfWeeks().add(DayOfWeek.THURSDAY);
            getDayOfWeeks().add(DayOfWeek.FRIDAY);
            setHourTo(7);
            setMinFrom(0);

            setHourFrom(10);
            setMinTo(30);
            getEndpoints().add(new Endpoint() {{
                setSource(Zone.Zone1);
                setDestination(Zone.Zone1);
            }});
            getEndpoints().add(new Endpoint() {{
                setSource(Zone.Zone1);
                setDestination(Zone.Zone2);
            }});
            getEndpoints().add(new Endpoint() {{
                setSource(Zone.Zone2);
                setDestination(Zone.Zone2);
            }});
            getEndpoints().add(new Endpoint() {{
                setSource(Zone.Zone2);
                setDestination(Zone.Zone1);
            }});
        }});

        PEAK_HOURS_CONF_LIST.add(new PeakDemand() {{
            getDayOfWeeks().add(DayOfWeek.SATURDAY);
            getDayOfWeeks().add(DayOfWeek.SUNDAY);
            setHourTo(9);
            setMinFrom(0);

            setHourFrom(11);
            setMinTo(0);
            getEndpoints().add(new Endpoint() {{
                setSource(Zone.Zone1);
                setDestination(Zone.Zone1);
            }});
            getEndpoints().add(new Endpoint() {{
                setSource(Zone.Zone1);
                setDestination(Zone.Zone2);
            }});
            getEndpoints().add(new Endpoint() {{
                setSource(Zone.Zone2);
                setDestination(Zone.Zone2);
            }});
            getEndpoints().add(new Endpoint() {{
                setSource(Zone.Zone2);
                setDestination(Zone.Zone1);
            }});
        }});

        PEAK_HOURS_CONF_LIST.add(new PeakDemand() {{
            getDayOfWeeks().add(DayOfWeek.MONDAY);
            getDayOfWeeks().add(DayOfWeek.TUESDAY);
            getDayOfWeeks().add(DayOfWeek.WEDNESDAY);
            getDayOfWeeks().add(DayOfWeek.THURSDAY);
            getDayOfWeeks().add(DayOfWeek.FRIDAY);
            setHourTo(17);
            setMinFrom(0);

            setHourFrom(20);
            setMinTo(30);
            getEndpoints().add(new Endpoint() {{
                setSource(Zone.Zone1);
                setDestination(Zone.Zone1);
            }});
            getEndpoints().add(new Endpoint() {{
                setSource(Zone.Zone2);
                setDestination(Zone.Zone2);
            }});
            getEndpoints().add(new Endpoint() {{
                setSource(Zone.Zone2);
                setDestination(Zone.Zone1);
            }});
        }});

        PEAK_HOURS_CONF_LIST.add(new PeakDemand() {{
            getDayOfWeeks().add(DayOfWeek.SATURDAY);
            getDayOfWeeks().add(DayOfWeek.SUNDAY);
            setHourTo(18);
            setMinFrom(0);

            setHourFrom(20);
            setMinTo(0);
            getEndpoints().add(new Endpoint() {{
                setSource(Zone.Zone1);
                setDestination(Zone.Zone1);
            }});
            getEndpoints().add(new Endpoint() {{
                setSource(Zone.Zone2);
                setDestination(Zone.Zone2);
            }});
            getEndpoints().add(new Endpoint() {{
                setSource(Zone.Zone2);
                setDestination(Zone.Zone1);
            }});
        }});
    }
}
