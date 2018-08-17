package com.kodilla.patterns2.decorator.pizza;

import java.util.List;

public class ExtraCheesePizzaOrderDecorator extends AbstractPizzaOrderDecorator {

    public ExtraCheesePizzaOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public double getCost() {
        return super.getCost()+5;
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredientsList=super.getIngredients();
        ingredientsList.add("Extra cheese");
        return ingredientsList;
    }

}
