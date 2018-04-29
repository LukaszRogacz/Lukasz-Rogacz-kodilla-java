package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException();
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     *
     * @param args
     */

    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();
        double result;
        try {
            result = firstChallenge.divide(3, 0);
        }
        catch (Exception e) {
            System.out.println("Division by 0. Error" + e);
            System.out.println("As a result of division by 0, there is returned the highest value");
            result = Double.MAX_VALUE;
        }


        System.out.println(result);


    }
}