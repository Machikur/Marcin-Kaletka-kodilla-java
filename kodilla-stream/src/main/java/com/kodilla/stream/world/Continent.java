package com.kodilla.stream.world;

import java.util.Set;

public final class Continent {

    private final Set<Country> countries;

    public Continent(final Set<Country> countries) {
        this.countries = countries;
    }

    public Set<Country> getCountries() {
        return countries;
    }

}
