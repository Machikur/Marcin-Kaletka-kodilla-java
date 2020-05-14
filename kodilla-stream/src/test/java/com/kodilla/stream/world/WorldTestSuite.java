package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashSet;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        Country poland = new Country(10000000);
        Country germany = new Country(15000000);
        Country ukraine = new Country(20000000);
        Country china = new Country(300000000);
        Country uk = new Country(400000000);

        HashSet<Country> continent1 = new HashSet<>();
        HashSet<Country> continent2 = new HashSet<>();
        continent1.add(poland);
        continent1.add(germany);
        continent1.add(ukraine);
        continent1.add(uk);
        continent2.add(china);

        Continent asia = new Continent(continent2);
        Continent europe = new Continent(continent1);
        HashSet<Continent> continents = new HashSet<>();
        continents.add(asia);
        continents.add(europe);

        World world = new World(continents);

        //When
        BigDecimal worldPeopleQuanity = world.getPeopleQuantity();

        //Then
        Assert.assertEquals(new BigDecimal(745000000), worldPeopleQuanity);
    }
}
