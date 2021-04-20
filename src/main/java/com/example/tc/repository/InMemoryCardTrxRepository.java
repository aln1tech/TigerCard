package com.example.tc.repository;

import com.example.tc.model.entities.TigerCard;
import com.example.tc.model.entities.TigerCardTrx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class InMemoryCardTrxRepository {
    private ConcurrentMap<TigerCard, TigerCardTrx> transientTrxStore = new ConcurrentHashMap<>();
    private ConcurrentMap<TigerCard, List<TigerCardTrx>> completedTrxStore = new ConcurrentHashMap<>();


    public void addCompletedTrx(TigerCard card, TigerCardTrx trx){
        completedTrxStore.putIfAbsent(card, new ArrayList<>());
        completedTrxStore.get(card).add(trx);
    }

    public void addTransientTrx(TigerCard card, TigerCardTrx trx){
        transientTrxStore.put(card, trx);
    }

    public TigerCardTrx getTransientTrx(TigerCard card) {
        return transientTrxStore.remove(card);
    }

    public List<TigerCardTrx> getCompletedTrxs(TigerCard card) {
        return completedTrxStore.getOrDefault(card, Collections.emptyList());
    }
}
