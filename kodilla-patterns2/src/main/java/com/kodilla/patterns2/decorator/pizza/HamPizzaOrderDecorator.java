package com.kodilla.patterns2.decorator.pizza;

import java.util.List;

public class HamPizzaOrderDecorator extends AbstractPizzaOrderDecorator {
    public HamPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public double getCost() {
        return super.getCost()+4;
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredientsList=super.getIngredients();
        ingredientsList.add("Ham");
        return ingredientsList;
    }
}
