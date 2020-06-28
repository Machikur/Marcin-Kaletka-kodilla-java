package com.kodilla.good.patterns.challenges.fourthtask.airport;

import com.kodilla.good.patterns.challenges.fourthtask.fly.Fly;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlySearch {

    private List<Fly> flyList;

    public FlySearch(List<Fly> flyList) {
        this.flyList = flyList;
    }

    public List<Fly> getFlightsFrom(String from) {
        return flyList.stream()
                .filter(s -> s.getFrom().equals(from))
                .collect(Collectors.toList());
    }

    public List<Fly> getFlightsTo(String to) {
        return flyList.stream()
                .filter(s -> s.getTo().equals(to))
                .collect(Collectors.toList());
    }


    public List<Fly> getFlyWithTransfer(String from, String to) {
        List<Fly> result = new ArrayList<>();
        for (Fly fly : flyList) {
            if (fly.getFrom().equals(from)) {
                String transfer = fly.getTo();
                List<Fly> tempList = getFlightsFrom(transfer);
                for (Fly f : tempList
                ) {
                    if (f.getTo().equals(to)) {
                        result.add(new Fly(fly.getFrom(), fly.getTo(), f.getTo()));
                    }

                }
            }
        }
        return result;
    }

}
