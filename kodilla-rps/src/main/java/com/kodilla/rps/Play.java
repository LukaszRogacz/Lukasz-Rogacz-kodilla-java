package com.kodilla.rps;

public class Play {
    private int computerPlay;
    private int userPlay;

    public Play(int userPlay,int computerPlay) {
        this.computerPlay = computerPlay;
        this.userPlay = userPlay;
    }


    public int getComputerPlay() {
        return computerPlay;
    }

    public int getUserPlay() {
        return userPlay;
    }
}
