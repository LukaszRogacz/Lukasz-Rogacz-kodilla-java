package com.kodilla.rps;


public class RpsRunner {
    public static void main(String[] args) {

        boolean end = false;
        Check check=new Check();
        GameSettings gameSettings=new GameSettings();
        Information information=new Information();

        while (!end) {
            if (gameSettings.isNewGame()) {
                information.showIntroduction(gameSettings);
                information.showInstruction();
                gameSettings.setIsNewGame(false);
            }
            Play newPlay=check.checkChoices(gameSettings);
            end = check.shouldBeEnded(gameSettings);
            if(!end && !gameSettings.isNewGame()) {
                information.showChoices(newPlay);
                check.checkResult(newPlay, gameSettings);
                information.showResult(gameSettings);
                end = check.shouldBeEnded(gameSettings);
                information.showWinner(gameSettings);
            }
        }

        check.closeScanner();
        information.closeScanner();

    }
}
