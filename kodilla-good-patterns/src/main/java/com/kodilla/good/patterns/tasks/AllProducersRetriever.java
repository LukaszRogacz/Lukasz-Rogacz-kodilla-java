package com.kodilla.good.patterns.tasks;

import java.util.HashMap;
import java.util.Map;



public class AllProducersRetriever {
    public Map<String,Producer> retrieve(){

        Producer producer=new ExtraFoodShop("Potato",10.0);
        Producer producer2=new HealthyShop("Carrot",20.0);
        Producer producer3=new GlutenFreeShop("Bread",30.0);

        Map<String,Producer> allProducers=new HashMap<>();
        allProducers.put("Potato",producer);
        allProducers.put("Carrot",producer2);
        allProducers.put("Bread",producer3);

        return allProducers;
    }
}
