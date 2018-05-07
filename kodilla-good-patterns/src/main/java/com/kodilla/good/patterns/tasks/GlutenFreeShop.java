package com.kodilla.good.patterns.tasks;

import java.util.HashMap;
import java.util.Map;


public class GlutenFreeShop implements Producer {

    private static Map<Product, Double> Supply = new HashMap<>();


    public GlutenFreeShop(Product product, Double quantity) {
        addSupply(product, quantity);
    }

    public void addSupply(Product product, Double quantity) {
        ProducerProcessor producerProcessor=new ProducerProcessor();
        if(quantity>0) {
            producerProcessor.addSupply(product, quantity, Supply);
        }else{
            System.out.println("Quantity must be positive");
        }
    }

    public void getSupply(Product product, Double quantity) {
        ProducerProcessor producerProcessor=new ProducerProcessor();
        if(quantity>0) {
            producerProcessor.getSupply(product, quantity, Supply);
        }else{
            System.out.println("Quantity must be positive");
        }
    }

    public Map<Product, Double> getSupplyList(){
        return Supply;
    }

    @Override
    public void process(Product product, Double quantity) {
        getSupply(product,quantity);
        System.out.println("There was an order from GlutenFreeShop");
    }
}
