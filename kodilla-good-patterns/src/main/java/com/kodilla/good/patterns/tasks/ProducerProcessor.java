package com.kodilla.good.patterns.tasks;

import java.util.Map;

public class ProducerProcessor {


    public void addSupply(Product product, Double quantity, Map<Product, Double> Supply) {
        if (Supply.containsKey(product)) {
            double oldQuantity = Supply.get(product);
            Supply.replace(product, oldQuantity + quantity);
        } else {
            Supply.put(product, quantity);
        }
    }

    public void getSupply(Product product, Double quantity, Map<Product, Double> Supply){
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
