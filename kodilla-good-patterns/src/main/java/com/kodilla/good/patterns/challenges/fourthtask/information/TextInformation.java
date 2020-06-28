package com.kodilla.good.patterns.challenges.fourthtask.information;

import com.kodilla.good.patterns.challenges.fourthtask.fly.Fly;

import java.util.List;
import java.util.Objects;

public class TextInformation implements Information {

    public void printInformation(List<Fly> list, String from, String to) {
        if (Objects.nonNull(from) && Objects.isNull(to)) {
            System.out.println("Dostępne loty z " + from);
        } else if (Objects.isNull(from) && Objects.nonNull(to)) {
            System.out.println("Dostępne loty do " + to);
        } else {
            System.out.println("Dostępne loty z " + from + " do " + to);
        }
        if (list.isEmpty()) {
            System.out.println("brak połączeń");
        }
        for (Fly fly : list) {
            System.out.println(fly);
        }
    }
}
