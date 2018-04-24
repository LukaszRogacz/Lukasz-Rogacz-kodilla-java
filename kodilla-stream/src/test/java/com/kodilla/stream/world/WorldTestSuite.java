package com.kodilla.stream.world;

import com.kodilla.stream.sand.Europe;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        //Given
        //Europe
        Country Poland= new Country("38000000");
        Country Germany= new Country("60000000");
        Country France= new Country("50000000");

        Continent Europe=new Continent();
        Europe.addCountry(Poland);
        Europe.addCountry(Germany);
        Europe.addCountry(France);

        //Asia
        Country China= new Country("1200000000");
        Country India= new Country("1000000000");
        Country Japan= new Country("100000000");

        Continent Asia=new Continent();
        Asia.addCountry(China);
        Asia.addCountry(India);
        Asia.addCountry(Japan);

        //North America
        Country Mexico= new Country("50000000");
        Country USA= new Country("250000000");
        Country Canada= new Country("100000000");

        Continent NorthAmerica=new Continent();
        NorthAmerica.addCountry(Mexico);
        NorthAmerica.addCountry(USA);
        NorthAmerica.addCountry(Canada);

        //World
        World world=new World();
        world.addContinent(Europe);
        world.addContinent(Asia);
        world.addContinent(NorthAmerica);

        //When

        BigDecimal totalWorldPeople=world.getPeopleQuantity();

        //Then

        BigDecimal expectedWorldPeople = new BigDecimal("2848000000");
        Assert.assertEquals(expectedWorldPeople,totalWorldPeople);
    }

}
