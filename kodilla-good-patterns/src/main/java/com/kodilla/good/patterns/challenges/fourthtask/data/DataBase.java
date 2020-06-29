package com.kodilla.good.patterns.challenges.fourthtask.data;

import com.kodilla.good.patterns.challenges.fourthtask.fly.Fly;

import java.util.Collection;

public interface DataBase {

    Collection<Fly> getFliesCollection();

    void saveCollection(Collection<Fly> collection);
}
