package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.Set;

public final class World {

    private final Set<Continent> continents;

    public World(final Set<Continent> continents) {
        this.continents = continents;
    }

    public BigDecimal getPeopleQuantity() {
        return continents.stream()
                .flatMap(continents -> continents.getCountries().stream())
                .map(country -> country.getPeopleQuantity())
                .reduce(BigDecimal.ZERO, (sum, current) -> sum.add(current));

    }
}
