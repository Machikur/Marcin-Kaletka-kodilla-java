package com.kodilla.good.patterns.challenges.fourthtask.airport;

import com.kodilla.good.patterns.challenges.fourthtask.data.FliesData;
import com.kodilla.good.patterns.challenges.fourthtask.information.TextInformation;

public class FlyMenager {

    private final FliesData fliesData;
    private final FlySearch flySearch;
    private final TextInformation textInformation;

    public FlyMenager(FliesData fliesData, TextInformation textInformation) {
        this.fliesData = fliesData;
        this.flySearch = new FlySearch(fliesData.getFliesData());
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
}
