package com.kodilla.stream.world;

import java.math.BigDecimal;

public final class Country {
    private final BigDecimal peopleQuantity;
    public Country(String people){
        peopleQuantity=new BigDecimal(people);
    }
    public final BigDecimal getPeopleQuantity(){
        return peopleQuantity;
    }
}
