package com.kodilla.rps;

import java.util.Scanner;

public class Information {

    private Scanner scanner = new Scanner(System.in);

    public static void showComputerWonRound() {
        System.out.println("You LOST this round");
    }

    public static void showUserWonRound() {
        System.out.println("You WON this round");
    }

    public static void showDrawRound() {
        System.out.println("DRAW");
    }

    public void closeScanner() {
        scanner.close();
    }

    public void showWinner(GameSettings gameSettings) {
        if (gameSettings.getRoundWinNumber() == gameSettings.getUserWinRounds()) {
            System.out.println("You WON the game");
        }
        if (gameSettings.getRoundWinNumber() == gameSettings.getComputerWinRounds()) {
            System.out.println("You LOST the game");
        }
    }

    public void showInstruction() {
        System.out.println("key 1 - play \"stone\"");
        System.out.println("key 2 - play \"paper\"");
        System.out.println("key 3 - play \"scissors\"");
        System.out.println("key x - quit of the game");
        System.out.println("key n - restart new game");
    }

    public void showIntroduction(GameSettings gameSettings) {
        System.out.println("What is your name?");
        gameSettings.setUserName(scanner.next());
        System.out.println("Hi " + gameSettings.getUserName() + ". What should be the number of rounds for winning?");
        String roundWinNumberString;
        int roundWinNumber = 0;
        do {
            try {
                System.out.println("Please write integer number greater than 0.");
                roundWinNumberString = scanner.next();
                roundWinNumber = Integer.parseInt(roundWinNumberString);
            } catch (Exception e) {

            }
        } while (roundWinNumber <= 0);
        gameSettings.setRoundWinNumber(roundWinNumber);

    }

    public void showResult(GameSettings gameSettings) {
        System.out.println("Result is: " + gameSettings.getUserName() + "("
                + gameSettings.getUserWinRounds() + ") - Computer(" + gameSettings.getComputerWinRounds() + ")");
    }

    public void showChoices(Play play) {

        String userChoiceName = "???";
        int userPlay = play.getUserPlay();

        switch (userPlay) {
            case 1:
                userChoiceName = "stone";
                break;
            case 2:
                userChoiceName = "paper";
                break;
            case 3:
                userChoiceName = "scissors";
                break;
        }
        System.out.println("You chose " + userChoiceName);

        String computerChoiceName = "???";
        int computerPlay = play.getComputerPlay();

        switch (computerPlay) {
            case 1:
                computerChoiceName = "stone";
                break;
            case 2:
                computerChoiceName = "paper";
                break;
            case 3:
                computerChoiceName = "scissors";
                break;
        }

        System.out.println("Computer chose " + computerChoiceName);
    }
}
