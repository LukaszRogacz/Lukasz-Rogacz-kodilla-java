package com.kodilla.good.patterns.tasks;

import java.util.Map;

public interface Producer {
    void process(Product product,Double quantity);
    void addSupply(Product product, Double quantity);
    Map<Product, Double> getSupplyList();
}
