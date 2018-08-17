package com.kodilla.patterns2.decorator.pizza;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class PizzaOrderTestSuite {

    @Test
    public void testPizzaHamExtraCheeseGarlicSauceOlivesGetCost(){
        //Given
        PizzaOrder pizzaOrder=new BasicPizzaOrder();
        pizzaOrder=new HamPizzaOrderDecorator(pizzaOrder);
        pizzaOrder=new ExtraCheesePizzaOrderDecorator(pizzaOrder);
        pizzaOrder=new GarlicSaucePizzaOrderDecorator(pizzaOrder);
        pizzaOrder=new OlivesPizzaOrderDecorator(pizzaOrder);
        //When
        double theCost=pizzaOrder.getCost();
        //Then
        Assert.assertEquals(theCost,29.0,0.00001);
    }

    @Test
    public void testPizzaHamExtraCheeseGarlicSauceOlivesGetIngredients(){
        //Given
        PizzaOrder pizzaOrder=new BasicPizzaOrder();
        pizzaOrder=new HamPizzaOrderDecorator(pizzaOrder);
        pizzaOrder=new ExtraCheesePizzaOrderDecorator(pizzaOrder);
        pizzaOrder=new GarlicSaucePizzaOrderDecorator(pizzaOrder);
        pizzaOrder=new OlivesPizzaOrderDecorator(pizzaOrder);
        //When
        List<String> ingredients=pizzaOrder.getIngredients();
        //Then

        System.out.println(ingredients);

        Assert.assertTrue(ingredients.contains("Bottom"));
        Assert.assertTrue(ingredients.contains("Cheese"));
        Assert.assertTrue(ingredients.contains("Extra cheese"));
        Assert.assertTrue(ingredients.contains("Ham"));
        Assert.assertTrue(ingredients.contains("Olives"));
        Assert.assertTrue(ingredients.contains("Tomato sauce"));
        Assert.assertTrue(ingredients.contains("Garlic sauce"));
        Assert.assertEquals(7,ingredients.size());
    }
}
