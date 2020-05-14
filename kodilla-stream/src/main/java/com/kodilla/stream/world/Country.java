package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.Objects;

public final class Country {

    private final Long peopleQuantity;

    public Country(final long peopleQuantity) {
        this.peopleQuantity = peopleQuantity;
    }

    public BigDecimal getPeopleQuantity() {
        return new BigDecimal(peopleQuantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(peopleQuantity, country.peopleQuantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peopleQuantity);
    }
}
