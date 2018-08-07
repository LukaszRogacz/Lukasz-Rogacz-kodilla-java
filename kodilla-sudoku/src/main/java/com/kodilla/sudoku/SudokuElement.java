package com.kodilla.sudoku;

import java.util.HashSet;
import java.util.Set;

public class SudokuElement {

    public static final int EMPTY = -1;
    public static final int GAME_SIZE = 3;
    public static final int VALUE_MIN = 1;
    public static final int VALUE_MAX = (int) Math.pow(GAME_SIZE, 2);

    private int value;
    private Set<Integer> possibleValues;
    private int blockNumber;

    public SudokuElement() {
        this(GAME_SIZE);
    }

    private SudokuElement(int gameSize) {
        this.value = EMPTY;
        this.possibleValues = new HashSet<>();
        for (int i = 1; i <= Math.pow(gameSize, 2); i++) {
            this.possibleValues.add(i);
        }
    }

    public int getValue() {
        return value;
    }

    public int getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(int blockNumber) {
        this.blockNumber = blockNumber;
    }

    public void setValue(int value) {
        this.value = value;
        this.possibleValues.clear();
    }

    public void setPossibleValues(Set<Integer> possibleValues) {
        this.possibleValues = possibleValues;
    }

    public Set<Integer> getPossibleValues() {
        return possibleValues;
    }
}
