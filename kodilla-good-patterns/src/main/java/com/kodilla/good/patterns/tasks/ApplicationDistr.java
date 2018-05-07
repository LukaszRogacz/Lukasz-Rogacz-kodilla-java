package com.kodilla.good.patterns.tasks;

import java.util.List;

public class ApplicationDistr {

    public static void main(String[] args) {

        AllProducersRetriever allProducersRetriever=new AllProducersRetriever();
        List<Producer>allProducers= allProducersRetriever.retrieve();
        Product product3=new Product("Bread");
        OrderProcessor orderProcessor=new OrderProcessor(allProducers);
        orderProcessor.order(10,product3);
    }


}
