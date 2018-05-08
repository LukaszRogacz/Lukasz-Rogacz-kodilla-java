package com.kodilla.good.patterns.tasks;

import java.util.Map;

public interface Producer {
    void process(String product,Double quantity);
    void addSupply(String product, Double quantity);
    Map<String, Double> getSupplyList();
}
