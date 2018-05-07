package com.kodilla.good.patterns.tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderProcessor {

    private List<Producer> allProducers;

    public OrderProcessor(List<Producer> allProducers) {
        this.allProducers=allProducers;
    }

    public List<Producer> findNeededProducers(double quantity, Product product){
        List<Producer> neededProducer=new ArrayList<>();
        for (Producer tempProducer : allProducers){
            if(tempProducer.getSupplyList().containsKey(product)
                    && tempProducer.getSupplyList().get(product)>=quantity){
                neededProducer.add(tempProducer);
            }
        }
        return neededProducer;
    }

    public Producer selectTheProducer(double quantity, Product product){
        List<Producer> theProducer=findNeededProducers(quantity,product);
        int size=theProducer.size();

        Random random=new Random();
        try {
            return theProducer.get(random.nextInt(size));
        }
        catch (Exception e){
            return null;
        }
    }

    public void order(double quantity, Product product) {

        try {
            selectTheProducer(quantity,product).process(product,quantity);
        }
        catch (Exception e){
            System.out.println("There is no Producer with such product and/or quantity");
        }

    }

}
