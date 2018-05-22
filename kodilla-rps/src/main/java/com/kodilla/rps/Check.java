package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;

public class Check {
    private Scanner scanner = new Scanner(System.in);
    private final static int MAX_NUMBER_PLAY = 3;

    public void closeScanner() {
        scanner.close();
    }

    public boolean areYouSureExitGame() {
        System.out.println("Are you sure you want to exit the game? [y/n] ");
        String key = scanner.next();
        if ("y".equals(key)) {
            return true;
        } else if ("n".equals(key)) {
            return false;
        } else {
            return areYouSureExitGame();
        }

    }

    public boolean areYouSureNewGame() {
        System.out.println("Are you sure you want to start new game? [y/n] ");
        String key = scanner.next();
        if ("y".equals(key)) {
            return true;
        } else if ("n".equals(key)) {
            return false;
        } else {
            return areYouSureNewGame();
        }

    }


    public Play checkChoices(GameSettings gameSettings) {

        String key ;
        int userPlay;
        int computerCheatPlay;
        do {
            key="";
            userPlay=0;
            computerCheatPlay=-1;
            try {
                System.out.println("Please write one of the options from menu");
                key = scanner.next();

                String keyOriginal=key;
                int cheatIndex=keyOriginal.indexOf("cheat");
                System.out.println("cheatIndex="+cheatIndex);

                if(cheatIndex<0){
                    userPlay = Integer.parseInt(keyOriginal);

                }else{
                    key=keyOriginal.substring(0,cheatIndex);
                    userPlay = Integer.parseInt(key);
                    computerCheatPlay = Integer.parseInt(keyOriginal.substring(cheatIndex+5));
                }


            } catch (Exception e) {

            }

            if ("x".equals(key) && areYouSureExitGame()) {
                gameSettings.setFinishGame(true);
                return null;
            } else if ("n".equals(key) && areYouSureNewGame()) {
                gameSettings.setIsNewGame(true);
                gameSettings.setComputerWinRounds(0);
                gameSettings.setUserWinRounds(0);
                return null;
            }

        }
        while ((userPlay < 1) || (userPlay > MAX_NUMBER_PLAY));


        Random random = new Random();
        int computerPlay = random.nextInt(MAX_NUMBER_PLAY) + 1;
        if (computerCheatPlay>=1 && computerCheatPlay<=MAX_NUMBER_PLAY){
            computerPlay=computerCheatPlay;
        }
        return new Play(userPlay, computerPlay);
    }



    public void checkResult(Play play, GameSettings gameSettings) {

        int result = 3;
        if (((play.getUserPlay() == 1) && (play.getComputerPlay() == 3))
                || ((play.getUserPlay() == 2) && (play.getComputerPlay() == 1))
                || ((play.getUserPlay() == 3) && (play.getComputerPlay() == 2))) {
            result = 1;
        }
        if (((play.getUserPlay() == 1) && (play.getComputerPlay() == 2))
                || ((play.getUserPlay() == 2) && (play.getComputerPlay() == 3))
                || ((play.getUserPlay() == 3) && (play.getComputerPlay() == 1))) {
            result = 2;
        }


        if (result == 1) {
            gameSettings.addUserWinRounds();
            Information.showUserWonRound();
        } else if (result == 2) {
            gameSettings.addComputerWinRounds();
            Information.showComputerWonRound();
        } else {
            Information.showDrawRound();
        }
    }

    public boolean shouldBeEnded(GameSettings gameSettings) {
        if ((gameSettings.getUserWinRounds() >= gameSettings.getRoundWinNumber())
                || (gameSettings.getComputerWinRounds() >= gameSettings.getRoundWinNumber())
                || gameSettings.getIsFinishGame()) {
            return true;
        } else {
            return false;
        }
    }

}
