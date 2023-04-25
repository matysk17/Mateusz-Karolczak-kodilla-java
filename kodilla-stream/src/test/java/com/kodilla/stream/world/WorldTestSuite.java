package com.kodilla.stream.world;

import org.junit.jupiter.api.*;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        //Given
        World world = new World();

        Continent europa = new Continent("Europa");
        Continent asia = new Continent("Asia");
        Continent australia = new Continent("Australia");

        Country poland = new Country("Poland");
        Country holand = new Country("Holland");
        Country spain = new Country("Spain");
        Country japan = new Country("Japan");
        Country katar = new Country("Katar");
        Country china = new Country("China");
        Country australiaCountry = new Country("Australia");
        Country fiji = new Country("Fiji");
        Country slovenia = new Country("Slovenia");
        Country vietnam = new Country("Vietnam");

        world.addContinent(europa);
        world.addContinent(asia);
        world.addContinent(australia);

        europa.addCountry(poland);
        europa.addCountry(holand);
        europa.addCountry(spain);
        europa.addCountry(slovenia);

        asia.addCountry(japan);
        asia.addCountry(katar);
        asia.addCountry(vietnam);
        asia.addCountry(china);

        australia.addCountry(australiaCountry);
        australia.addCountry(fiji);

        //When

        BigDecimal totalPeople = world.getPeopleQuantity();
        //Then
        BigDecimal totalPeopleExpected = new BigDecimal("10000010");
        Assertions.assertEquals(totalPeopleExpected, totalPeople);
    }
}