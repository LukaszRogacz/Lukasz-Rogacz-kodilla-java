package com.kodilla.good.patterns.tasks;

import java.util.ArrayList;
import java.util.List;

public class AllProducersRetriever {
    public List<Producer> retrieve(){
        Product product=new Product("Potato");
        Product product2=new Product("Carrot");
        Product product3=new Product("Bread");
        Producer producer=new ExtraFoodShop(product,10.0);
        Producer producer2=new HealthyShop(product2,20.0);
        Producer producer3=new GlutenFreeShop(product3,30.0);

        List<Producer> allProducers=new ArrayList<Producer>();

        allProducers.add(producer);
        allProducers.add(producer2);
        allProducers.add(producer3);

        return allProducers;
    }
}
