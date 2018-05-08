package com.kodilla.good.patterns.tasks;

import java.util.Map;

public class ApplicationDistr {

    public static void main(String[] args) {

        AllProducersRetriever allProducersRetriever=new AllProducersRetriever();
        Map<String,Producer> allProducers= allProducersRetriever.retrieve();
        OrderProcessor orderProcessor=new OrderProcessor(allProducers);
        orderProcessor.order(10,"Bread");
    }


}
