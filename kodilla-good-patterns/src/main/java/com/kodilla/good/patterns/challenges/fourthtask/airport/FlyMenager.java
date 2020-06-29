package com.kodilla.good.patterns.challenges.fourthtask.airport;

import com.kodilla.good.patterns.challenges.fourthtask.data.DataBase;
import com.kodilla.good.patterns.challenges.fourthtask.information.TextInformation;

public class FlyMenager {

    private final FlySearch flySearch;
    private final TextInformation textInformation;

    public FlyMenager(DataBase dataBase, TextInformation textInformation) {
        this.flySearch = new FlySearch(dataBase);
        this.textInformation = textInformation;
    }


    public void getConnecting(String from, String to) {
        textInformation.printInformation(flySearch.getFlyWithTransfer(from, to), from, to);
    }

    public void getFliesTo(String to) {
        textInformation.printInformation(flySearch.getFlightsTo(to), null, to);
    }

    public void getFliesFrom(String from) {
        textInformation.printInformation(flySearch.getFlightsFrom(from), from, null);
    }

    public void saveFlies() {
        flySearch.saveFlies();
    }
}
