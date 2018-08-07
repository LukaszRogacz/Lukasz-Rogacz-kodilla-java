package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {

    private List<SudokuElement> sudokuRowElements = new ArrayList<>();

    public SudokuRow() {

    }


    public SudokuRow(int gameSize) {
        for (int i = 1; i <= Math.pow(gameSize, 2); i++) {
            this.sudokuRowElements.add(new SudokuElement());
        }
    }


    public List<SudokuElement> getSudokuRowElements() {
        return sudokuRowElements;
    }

    public void setSudokuRowElements(List<SudokuElement> sudokuRowElements) {
        this.sudokuRowElements = sudokuRowElements;
    }
}
