package com.kodilla.patterns2.decorator.pizza;

import java.util.List;

public class GarlicSaucePizzaOrderDecorator extends AbstractPizzaOrderDecorator {
    public GarlicSaucePizzaOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public double getCost() {
        return super.getCost()+2;
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredientsList=super.getIngredients();
        ingredientsList.add("Garlic sauce");
        return ingredientsList;
    }
}
