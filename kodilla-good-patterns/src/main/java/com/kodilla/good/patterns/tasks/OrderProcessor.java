package com.kodilla.good.patterns.tasks;

import java.util.*;

public class OrderProcessor {

    private Map<String,Producer> allProducers;

    public OrderProcessor(Map<String,Producer> allProducers) {
        this.allProducers=allProducers;
    }


    public Producer selectTheProducer(String product){

        try {
            return allProducers.get(product);
        }
        catch (Exception e){
            return null;
        }
    }

    public void order(double quantity, String product) {

        try {
            selectTheProducer(product).process(product,quantity);
        }
        catch (Exception e){
            System.out.println("There is no Producer with such product and/or quantity");
        }

    }

}
