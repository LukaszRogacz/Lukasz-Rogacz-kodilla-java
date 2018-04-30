package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            String myString = secondChallenge.probablyIWillThrowException(2, 3);
            System.out.println(myString);
        } catch (Exception e) {
            System.out.println("Throws Exception: "+e);
            System.out.println("x>=2 OR x<1 OR y=1.5");
        }
        finally {
            System.out.println("Done something, no matter what");
        }
    }

}
