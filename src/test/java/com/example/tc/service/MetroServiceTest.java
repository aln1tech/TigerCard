package com.example.tc.service;

import com.example.tc.constant.Globals;
import com.example.tc.model.entities.TigerCard;
import com.example.tc.model.entities.Traveller;
import com.example.tc.model.enums.Cap;
import com.example.tc.model.enums.Zone;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class MetroServiceTest {
    private MetroService metroService = new MetroService();

    private TigerCard card;

    @Before
    public void setUp() throws Exception {
        new Globals();
        metroService = new MetroService();
        card = new TigerCard();
        card.setTraveller(new Traveller(1L, "User 1"));
    }

    @Test
    public void testCalculateDailyCapAmount() throws Exception {
        LocalDateTime today = LocalDateTime.now();
        metroService.swipeIn(card, Zone.Zone2, LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), 18, 25));
        metroService.swipeOut(card, Zone.Zone1, LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), 18, 35));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), 19, 05));
        metroService.swipeOut(card, Zone.Zone1, LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), 19, 15));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), 19, 05));
        metroService.swipeOut(card, Zone.Zone1, LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), 19, 15));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), 19, 05));
        metroService.swipeOut(card, Zone.Zone1, LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), 19, 15));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), 19, 05));
        metroService.swipeOut(card, Zone.Zone1, LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), 19, 15));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), 19, 05));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(today.getYear(), today.getMonth(), today.getDayOfMonth(), 19, 15));

        assertThat("Daily Cap Reached ", metroService.calculateDailyCapAmount(card).intValue(), equalTo(120));
    }

    @Test
    public void testCalculateWeeklyCapAmount() throws Exception {
        LocalDate localDate = LocalDate.now().with(TemporalAdjusters.previousOrSame(WeekFields.of(Locale.getDefault()).getFirstDayOfWeek()));

        LocalDateTime date = localDate.atStartOfDay(); //monday

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        date = date.plusDays(1L); //tuesday

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));


        date = date.plusDays(1L); //wednesday

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        date = date.plusDays(1L); //thursday

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));


        date = date.plusDays(1L); //friday

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 11, 00));
        metroService.swipeOut(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 12, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 11, 00));
        metroService.swipeOut(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 12, 00));

        date = date.plusDays(1L); //saturday

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 11, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 12, 00));

        date = date.plusDays(1L); //sunday

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone2, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        date = date.plusDays(1L); //next monday

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        metroService.swipeIn(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 7, 00));
        metroService.swipeOut(card, Zone.Zone1, LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 8, 00));

        assertThat("Weekly Cap Reached ", metroService.calculateWeeklyCapAmount(card).intValue(), equalTo(700));
    }
}
