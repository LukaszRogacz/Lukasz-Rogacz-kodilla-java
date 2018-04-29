package com.kodilla.exception.test;

public class FirstChallenge {

    public double divide(double a, double b) throws ArithmeticException {

        try{
            if(b == 0){
                throw new ArithmeticException();
            }

        }
        catch (Exception e){
            System.out.println("Division by 0. Error"+e);
        }
        finally {

            if(b==0){
                System.out.println("As a result of division there is returned the highest value");
                return Double.MAX_VALUE;
            } else {
                return a / b;
            }
        }
        }

    /**
     * This main can throw an ArithmeticException!!!
     * @param args
     */
    public static void main(String[] args) {

        FirstChallenge firstChallenge = new FirstChallenge();

        double result = firstChallenge.divide(3, 0);


        System.out.println(result);

    }
}