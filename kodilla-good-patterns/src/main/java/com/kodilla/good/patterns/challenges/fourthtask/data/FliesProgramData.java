package com.kodilla.good.patterns.challenges.fourthtask.data;

import com.kodilla.good.patterns.challenges.fourthtask.fly.Fly;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FliesProgramData implements DataBase {

    public List<Fly> getFliesCollection() {
        List<Fly> list = new ArrayList<>();
        list.add(new Fly("Kraków", "Warszawa"));
        list.add(new Fly("Londyn", "Kraków"));
        list.add(new Fly("Praga", "Warszawa"));
        list.add(new Fly("Bruksela", "Warszawa"));
        list.add(new Fly("Wrocław", "Bruksela"));
        list.add(new Fly("Berlin", "Nowy York"));
        list.add(new Fly("Moskwa", "Warszawa"));
        list.add(new Fly("Nowy York", "Warszawa"));
        list.add(new Fly("Kraków", "Berlin"));
        list.add(new Fly("Warszawa", "Londyn"));
        list.add(new Fly("Warszawa", "Berlin"));
        list.add(new Fly("Warszawa", "Bruksela"));
        list.add(new Fly("Bruksela", "Nowy York"));
        list.add(new Fly("Bruksela", "Berlin"));
        return list;
    }

    public void saveCollection(Collection<Fly> collection) {

    }
}
