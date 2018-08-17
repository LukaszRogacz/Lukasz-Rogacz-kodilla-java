package com.kodilla.patterns2.decorator.pizza;

import java.util.List;

public class OlivesPizzaOrderDecorator extends AbstractPizzaOrderDecorator{
    public OlivesPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public double getCost() {
        return super.getCost()+3;
    }

    @Override
    public List<String> getIngredients() {
        List<String> ingredientsList=super.getIngredients();
        ingredientsList.add("Olives");
        return ingredientsList;
    }
}
