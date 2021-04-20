package com.example.tc.service;

import com.example.tc.constant.Globals;
import com.example.tc.model.entities.CappingLimit;
import com.example.tc.model.entities.DailyCapTrx;
import com.example.tc.model.entities.TigerCard;
import com.example.tc.model.entities.TigerCardTrx;
import com.example.tc.model.entities.WeeklyCapTrx;
import com.example.tc.model.enums.Cap;
import com.example.tc.model.enums.Zone;
import com.example.tc.repository.InMemoryCardTrxRepository;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MetroService {
    private ConcurrentMap<Zone, AtomicInteger> stationFootFall = new ConcurrentHashMap<>();

    private InMemoryCardTrxRepository trxRepository = new InMemoryCardTrxRepository();
    private FareCalculator fareCalculator = new FareCalculator();

    public void swipeIn(TigerCard card, Zone source, LocalDateTime dateTime) {
        stationFootFall.putIfAbsent(source, new AtomicInteger());
        stationFootFall.get(source).incrementAndGet();
        TigerCardTrx trx = new TigerCardTrx();
        trx.setSource(source);
        trx.setCard(card);
        trx.setStartTime(dateTime);
        trxRepository.addTransientTrx(card, trx);
    }

    public void swipeOut(TigerCard card, Zone destination, LocalDateTime dateTime) {
        stationFootFall.putIfAbsent(destination, new AtomicInteger());
        stationFootFall.get(destination).incrementAndGet();
        TigerCardTrx trx = trxRepository.getTransientTrx(card);
        trx.setDestination(destination);
        trx.setEndTime(dateTime);
        trx.setFare(fareCalculator.getFare(trx.getSource(), trx.getDestination(), dateTime));
        trxRepository.addCompletedTrx(card, trx);
    }

    private void addWeeklyFareTrx(Map<WeeklyCapTrx, WeeklyCapTrx> weeklyFareTrxSet, DailyCapTrx trx, Optional<CappingLimit> optionalCappingLimit, WeeklyCapTrx weeklyCapTrx) {
        weeklyCapTrx.setSource(trx.getSource());
        weeklyCapTrx.setDestination(trx.getDestination());
        if (weeklyCapTrx.getCapLimit() < optionalCappingLimit.get().getFare()) {
            weeklyCapTrx.setCapLimit(optionalCappingLimit.get().getFare());
        }
        Double total = trx.getTotalFare() + weeklyCapTrx.getTotalFare();
        if (weeklyCapTrx.getTotalFare() >= weeklyCapTrx.getCapLimit() || total >= weeklyCapTrx.getCapLimit()) {
            weeklyCapTrx.setTotalFare(weeklyCapTrx.getCapLimit());
        } else {
            weeklyCapTrx.setTotalFare(total);
        }
        weeklyFareTrxSet.put(weeklyCapTrx, weeklyCapTrx);
    }

    private void addDailyFareTrx(Map<DailyCapTrx, DailyCapTrx> dailyFareTrxMap, TigerCardTrx trx, Optional<CappingLimit> optionalCappingLimit, DailyCapTrx dailyCapTrx) {
        dailyCapTrx.setSource(trx.getSource());
        dailyCapTrx.setDestination(trx.getDestination());
        if (dailyCapTrx.getCapLimit() < optionalCappingLimit.get().getFare()) {
            dailyCapTrx.setCapLimit(optionalCappingLimit.get().getFare());
        }
        Double total = trx.getFare() + dailyCapTrx.getTotalFare();
        if (dailyCapTrx.getTotalFare() >= dailyCapTrx.getCapLimit() || total >= dailyCapTrx.getCapLimit()) {
            dailyCapTrx.setTotalFare(dailyCapTrx.getCapLimit());
        } else {
            dailyCapTrx.setTotalFare(total);
        }
        dailyFareTrxMap.put(dailyCapTrx, dailyCapTrx);
    }

    public Map<WeeklyCapTrx, WeeklyCapTrx> calculateWeeklyTrx(TigerCard card) {
        final Map<WeeklyCapTrx, WeeklyCapTrx> weeklyFareTrxMap = new HashMap<>();
        Map<DailyCapTrx, DailyCapTrx> dailyCapTrxMap = calculateDailyTrx(card);
        dailyCapTrxMap.entrySet().stream().forEach(dailyCapTrxDailyCapTrxEntry -> {
            DailyCapTrx dailyCapTrx = dailyCapTrxDailyCapTrxEntry.getValue();
            final Optional<CappingLimit> optionalWeeklyCappingLimit = Globals.CAPPING_LIMIT_LIST.stream()
                    .filter(cappingLimit -> cappingLimit.getSource().equals(dailyCapTrx.getSource())
                            && cappingLimit.getDestination().equals(dailyCapTrx.getDestination())
                            && cappingLimit.getCap().equals(Cap.WEEKLY)).findAny();
            if (optionalWeeklyCappingLimit.isPresent()) {
                int weekNo = dailyCapTrx.getTravelDate().get(WeekFields.of(Locale.getDefault()).weekOfYear());
                final WeeklyCapTrx weeklyCapTrx =
                        new WeeklyCapTrx(card.getTraveller(), weekNo);
                if (weeklyFareTrxMap.containsKey(weeklyCapTrx)) {
                    weeklyCapTrx.setTotalFare(weeklyFareTrxMap.get(weeklyCapTrx).getTotalFare());
                    weeklyCapTrx.setCapLimit(weeklyFareTrxMap.get(weeklyCapTrx).getCapLimit());
                    addWeeklyFareTrx(weeklyFareTrxMap, dailyCapTrx, optionalWeeklyCappingLimit, weeklyCapTrx);
                } else {
                    addWeeklyFareTrx(weeklyFareTrxMap, dailyCapTrx, optionalWeeklyCappingLimit, weeklyCapTrx);
                }
            }
        });
        return weeklyFareTrxMap;
    }

    public Map<DailyCapTrx, DailyCapTrx> calculateDailyTrx(TigerCard card) {
        final Map<DailyCapTrx, DailyCapTrx> dailyFareTrxMap = new HashMap<>();
        List<TigerCardTrx> trxs = trxRepository.getCompletedTrxs(card);
        trxs.forEach(trx -> {
            final Optional<CappingLimit> optionalDailyCappingLimit = Globals.CAPPING_LIMIT_LIST.stream()
                    .filter(cappingLimit -> cappingLimit.getSource().equals(trx.getSource())
                            && cappingLimit.getDestination().equals(trx.getDestination())
                            && cappingLimit.getCap().equals(Cap.DAILY)).findAny();
            final DailyCapTrx dailyCapTrx =
                    new DailyCapTrx(trx.getCard().getTraveller(), trx.getEndTime().toLocalDate());
            if (optionalDailyCappingLimit.isPresent()) {
                if (dailyFareTrxMap.containsKey(dailyCapTrx)) {
                    dailyCapTrx.setTotalFare(dailyFareTrxMap.get(dailyCapTrx).getTotalFare());
                    dailyCapTrx.setCapLimit(dailyFareTrxMap.get(dailyCapTrx).getCapLimit());
                    addDailyFareTrx(dailyFareTrxMap, trx, optionalDailyCappingLimit, dailyCapTrx);
                } else {
                    addDailyFareTrx(dailyFareTrxMap, trx, optionalDailyCappingLimit, dailyCapTrx);
                }
            }
        });
        return dailyFareTrxMap;
    }

    public Double calculateDailyCapAmount(TigerCard card) {
        Map<DailyCapTrx, DailyCapTrx> dailyFareTrxMap = calculateDailyTrx(card);
        return dailyFareTrxMap.values().stream().mapToDouble(DailyCapTrx::getTotalFare).sum();
    }

    public Double calculateWeeklyCapAmount(TigerCard card) {
        Map<WeeklyCapTrx, WeeklyCapTrx> weeklyCapTrxMap = calculateWeeklyTrx(card);
        return weeklyCapTrxMap.values().stream().mapToDouble(WeeklyCapTrx::getTotalFare).sum();
    }
}
