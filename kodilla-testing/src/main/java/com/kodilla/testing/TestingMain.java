package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;


public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("Test - first unit test; method add from class Calculator:");

        Calculator myCalculator = new Calculator();

        if (myCalculator.add(2, 3) == 5) {
            System.out.println("test(class Calculator; method add) OK");
        } else {
            System.out.println("Error! (class Calculator; method add)");
        }

        System.out.println("Test - second unit test; method subtract from class Calculator:");

        if (myCalculator.subtract(21, 3) == 18) {
            System.out.println("test(class Calculator; method subtract) OK");
        } else {
            System.out.println("Error! (class Calculator; method subtract)");
        }
    }
}
