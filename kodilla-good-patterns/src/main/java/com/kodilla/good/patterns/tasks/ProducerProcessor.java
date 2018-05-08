package com.kodilla.good.patterns.tasks;

import java.util.Map;

public class ProducerProcessor {


    public void addSupply(String product, Double quantity, Map<String, Double> supply) {
        if (supply.containsKey(product)) {
            double oldQuantity = supply.get(product);
            supply.replace(product, oldQuantity + quantity);
        } else {
            supply.put(product, quantity);
        }
    }

    public void getSupply(String product, Double quantity, Map<String, Double> Supply){
        if (Supply.containsKey(product)) {
            double oldQuantity = Supply.get(product);
            if (oldQuantity >= quantity) {
                Supply.replace(product, oldQuantity - quantity);
            }
        } else {
            System.out.println("There is no such product");
        }

    }



}
