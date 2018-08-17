package com.kodilla.patterns2.decorator.pizza;

import java.util.ArrayList;
import java.util.List;

public class BasicPizzaOrder implements PizzaOrder {

    private final List<String> ingredients = new ArrayList<>();

    public BasicPizzaOrder() {
        ingredients.add("Bottom");
        ingredients.add("Tomato sauce");
        ingredients.add("Cheese");
    }

    @Override
    public double getCost() {
        return 15;
    }

    @Override
    public List<String> getIngredients() {
        return ingredients;
    }

}
