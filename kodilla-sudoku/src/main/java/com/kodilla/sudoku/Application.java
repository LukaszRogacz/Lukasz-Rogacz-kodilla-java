package com.kodilla.sudoku;

public class Application {

    public static void main(String[] args) throws CloneNotSupportedException {
        boolean gameFinished = false;

        while (!gameFinished) {

            SudokuGame theGame = new SudokuGame();
            theGame.startSudoku();
            gameFinished = theGame.resolveSudoku();

        }
    }
}
