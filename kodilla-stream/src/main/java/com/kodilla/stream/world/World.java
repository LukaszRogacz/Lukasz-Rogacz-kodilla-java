package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public final class World {
    private final Set<Continent> continentsList=new HashSet<>();
    public void addContinent(Continent continent){
        continentsList.add(continent);
    }
    public boolean removeContinent(Continent continent){
        return continentsList.remove(continent);
    }
    public BigDecimal getPeopleQuantity(){
        return continentsList.stream()
                .flatMap(continent->continent.getCountryList().stream())
                .map(country -> country.getPeopleQuantity())
                .reduce(BigDecimal.ZERO,(sum,current)-> sum=current.add(sum));
    }
}