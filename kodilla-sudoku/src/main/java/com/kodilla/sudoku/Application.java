package com.kodilla.sudoku;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws CloneNotSupportedException {
        boolean gameFinished = false;

        while (!gameFinished) {

            Scanner scanner = MyScanner.getInstance();
            SudokuGame theGame = new SudokuGame();
            theGame.startSudoku();
            gameFinished = theGame.resolveSudoku();

            if (gameFinished) {
                scanner.close();
            }

        }
    }
}
