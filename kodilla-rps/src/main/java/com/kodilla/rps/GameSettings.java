package com.kodilla.rps;

public class GameSettings {

    private String userName="";
    private int computerWinRounds=0;
    private int userWinRounds=0;
    private int roundWinNumber;
    private boolean isNewGame=true;

    private boolean finishGame=false;

    public boolean getIsFinishGame() {
        return finishGame;
    }

    public GameSettings() {

    }

    public String getUserName() {
        return userName;
    }

    public int getComputerWinRounds() {
        return computerWinRounds;
    }

    public int getUserWinRounds() {
        return userWinRounds;
    }

    public int getRoundWinNumber() {
        return roundWinNumber;
    }

    public boolean isNewGame() {
        return isNewGame;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setComputerWinRounds(int computerWinRounds) {
        this.computerWinRounds = computerWinRounds;
    }

    public void setUserWinRounds(int userWinRounds) {
        this.userWinRounds = userWinRounds;
    }

    public void setRoundWinNumber(int roundWinNumber) {
        this.roundWinNumber = roundWinNumber;
    }

    public void setIsNewGame(boolean isNewGame) {
        this.isNewGame = isNewGame;
    }

    public void setFinishGame(boolean finishGame) {
        this.finishGame = finishGame;
    }

    public void addComputerWinRounds(){
        computerWinRounds++;
    }

    public void addUserWinRounds(){
        userWinRounds++;
    }

}
