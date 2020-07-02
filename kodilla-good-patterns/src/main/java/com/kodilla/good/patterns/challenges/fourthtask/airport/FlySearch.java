package com.kodilla.good.patterns.challenges.fourthtask.airport;

import com.kodilla.good.patterns.challenges.fourthtask.data.DataBase;
import com.kodilla.good.patterns.challenges.fourthtask.fly.Fly;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlySearch {

    private final Collection<Fly> flyCollection;
    private final DataBase dataBase;

    public FlySearch(DataBase dataBase) {
        this.dataBase = dataBase;
        this.flyCollection = dataBase.getFliesCollection();
    }

    public List<Fly> getFlightsFrom(String from) {
        return flyCollection.stream()
                .filter(s -> s.getFrom().equals(from))
                .collect(Collectors.toList());
    }

    public List<Fly> getFlightsTo(String to) {
        return flyCollection.stream()
                .filter(s -> s.getTo().equals(to))
                .collect(Collectors.toList());
    }

    public List<Fly> getFlyWithTransfer(String from, String to) {
        return flyCollection.stream()
                .filter(fly -> fly.getFrom().equals(from))
                .filter(fly -> getFlightsTo(to).stream().anyMatch(f -> f.getFrom().equals(fly.getTo())) || fly.getTo().equals(to))
                .map(fly -> {
                    if (!fly.getTo().equals(to)) {
                        return new Fly(from, fly.getTo(), to);
                    } else {
                        return fly;
                    }
                })
                .collect(Collectors.toList());
    }

    public void saveFlies() {
        dataBase.saveCollection(flyCollection);
    }

}
