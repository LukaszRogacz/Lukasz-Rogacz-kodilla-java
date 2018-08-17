package com.kodilla.patterns2.decorator.pizza;

import java.util.List;

public abstract class AbstractPizzaOrderDecorator implements PizzaOrder {

    private final PizzaOrder pizzaOrder;

    public AbstractPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    @Override
    public double getCost() {
        return pizzaOrder.getCost();
    }

    @Override
    public List<String> getIngredients() {
        return pizzaOrder.getIngredients();
    }
}
