package com.kodilla.sudoku;

public class SudokuState {

    private SudokuBoard sudokuBoard;
    private int i;
    private int j;
    private int guessedValue;

    public SudokuState(SudokuBoard sudokuBoard, int i, int j, int guessedValue) throws CloneNotSupportedException {
        this.sudokuBoard = sudokuBoard;
        this.i = i;
        this.j = j;
        this.guessedValue = guessedValue;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getGuessedValue() {
        return guessedValue;
    }
}
