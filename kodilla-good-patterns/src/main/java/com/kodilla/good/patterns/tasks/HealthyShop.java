package com.kodilla.good.patterns.tasks;

import java.util.HashMap;
import java.util.Map;


public class HealthyShop implements Producer {

    private static Map<String, Double> supply = new HashMap<>();


    public HealthyShop(String product, Double quantity) {
        addSupply(product, quantity);
    }

    public void addSupply(String product, Double quantity) {
        ProducerProcessor producerProcessor=new ProducerProcessor();
        if(quantity>0) {
            producerProcessor.addSupply(product, quantity, supply);
        }else{
            System.out.println("Quantity must be positive");
        }
    }

    public void getSupply(String product, Double quantity) {
        ProducerProcessor producerProcessor=new ProducerProcessor();
        if(quantity>0) {
            producerProcessor.getSupply(product, quantity, supply);
        }else{
            System.out.println("Quantity must be positive");
        }
    }

    public Map<String, Double> getSupplyList(){
        return supply;
    }

    @Override
    public void process(String product, Double quantity) {
        getSupply(product,quantity);
        System.out.println("There was an order from HealthyShop");
    }
}
