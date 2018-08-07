package com.kodilla.sudoku;

import java.util.*;

public class SudokuGame {


    private SudokuBoard sudokuBoard;
    private boolean anyChange = false;
    private Deque<SudokuState> backtrack = new ArrayDeque<>();
    private int guessIterationCounter = 0;
    private Check check = new Check();

    public SudokuGame() {
        this.sudokuBoard = new SudokuBoard();

    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    private void removePossibleValuesEveryDimension(int x, int y, int value) {

        int blockNumber = getBlockNumber(x, y);
        for (int i = SudokuElement.VALUE_MIN - 1; i < SudokuElement.VALUE_MAX; i++) {
            for (int j = SudokuElement.VALUE_MIN - 1; j < SudokuElement.VALUE_MAX; j++) {
                if ((i == x) || (j == y) || (blockNumber == getBlockNumber(i, j))) {
                    getSudokuBoardPossibleValues(i, j).remove(value);
                }
            }
        }

    }

    public void setSudokuBoardValue(int x, int y, int value) {
        if (getSudokuBoardValue(x, y) == SudokuElement.EMPTY) {
            this.sudokuBoard.getSudokuRowList().get(y).getSudokuRowElements().get(x).setValue(value);
            removePossibleValuesEveryDimension(x, y, value);
            anyChange = true;

        } else {
            System.out.println("The value on position (" + x + "," + y + ") is set already, please select another cell");
        }

        System.out.println(this.sudokuBoard);

    }

    private int getSudokuBoardValue(int x, int y) {
        return this.sudokuBoard.getSudokuRowList().get(y).getSudokuRowElements().get(x).getValue();
    }

    private Set<Integer> getSudokuBoardPossibleValues(int x, int y) {
        return this.sudokuBoard.getSudokuRowList().get(y).getSudokuRowElements().get(x).getPossibleValues();
    }

    private void solveRow() {
        for (int i = SudokuElement.VALUE_MIN - 1; i < SudokuElement.VALUE_MAX; i++) {

            Set<Integer> rowValues = new HashSet<>();
            rowValues.clear();

            for (int j = SudokuElement.VALUE_MIN - 1; j < SudokuElement.VALUE_MAX; j++) {
                int rowValue = getSudokuBoardValue(i, j);
                if (rowValue != SudokuElement.EMPTY) {
                    rowValues.add(rowValue);
                }
            }
            for (int j = SudokuElement.VALUE_MIN - 1; j < SudokuElement.VALUE_MAX; j++) {
                int rowValue = getSudokuBoardValue(i, j);
                if (rowValue == SudokuElement.EMPTY) {
                    int quantityPossibleValuesBefore = getSudokuBoardPossibleValues(i, j).size();
                    getSudokuBoardPossibleValues(i, j).removeAll(rowValues);
                    int quantityPossibleValuesAfter = getSudokuBoardPossibleValues(i, j).size();

                    if (quantityPossibleValuesAfter != quantityPossibleValuesBefore) {
                        anyChange = true;
                    }

                    if (getSudokuBoardPossibleValues(i, j).size() == 1) {
                        int onlyPossibleValue = SudokuElement.EMPTY;
                        for (int value : getSudokuBoardPossibleValues(i, j)) {
                            onlyPossibleValue = value;
                        }

                        setSudokuBoardValue(i, j, onlyPossibleValue);

                    }
                }
            }
        }

    }

    private void solveColumn() {
        for (int i = SudokuElement.VALUE_MIN - 1; i < SudokuElement.VALUE_MAX; i++) {

            Set<Integer> columnValues = new HashSet<>();
            columnValues.clear();

            for (int j = SudokuElement.VALUE_MIN - 1; j < SudokuElement.VALUE_MAX; j++) {
                int columnValue = getSudokuBoardValue(j, i);
                if (columnValue != SudokuElement.EMPTY) {
                    columnValues.add(columnValue);
                }
            }
            for (int j = SudokuElement.VALUE_MIN - 1; j < SudokuElement.VALUE_MAX; j++) {
                int columnValue = getSudokuBoardValue(j, i);
                if (columnValue == SudokuElement.EMPTY) {

                    int quantityPossibleValuesBefore = getSudokuBoardPossibleValues(j, i).size();
                    getSudokuBoardPossibleValues(j, i).removeAll(columnValues);
                    int quantityPossibleValuesAfter = getSudokuBoardPossibleValues(j, i).size();

                    if (quantityPossibleValuesAfter != quantityPossibleValuesBefore) {
                        anyChange = true;
                    }
                    if (getSudokuBoardPossibleValues(j, i).size() == 1) {
                        int onlyPossibleValue = SudokuElement.EMPTY;
                        for (int value : getSudokuBoardPossibleValues(j, i)) {
                            onlyPossibleValue = value;
                        }

                        setSudokuBoardValue(j, i, onlyPossibleValue);

                    }
                }
            }
        }


    }

    private void solveRow2() {
        for (int j = SudokuElement.VALUE_MIN - 1; j < SudokuElement.VALUE_MAX; j++) {

            int[] howManyNumbersinOneDimension = new int[SudokuElement.VALUE_MAX];
            int[] howManyNumbersinOneDimension2 = howManyNumbersinOneDimension.clone();

            for (int k = SudokuElement.VALUE_MIN - 1; k < SudokuElement.VALUE_MAX; k++) {
                for (int ii = SudokuElement.VALUE_MIN - 1; ii < SudokuElement.VALUE_MAX; ii++) {
                    if (getSudokuBoardPossibleValues(ii, j).contains(k + 1)) {
                        howManyNumbersinOneDimension2[k]++;
                    }
                }
            }
            for (int k = SudokuElement.VALUE_MIN - 1; k < SudokuElement.VALUE_MAX; k++) {
                for (int i = SudokuElement.VALUE_MIN - 1; i < SudokuElement.VALUE_MAX; i++) {

                    if ((howManyNumbersinOneDimension2[k] == 1) && getSudokuBoardPossibleValues(i, j).contains(k + 1)) {
                        setSudokuBoardValue(i, j, k + 1);
                    }
                }
            }
        }


    }


    private void solveColumn2() {
        for (int i = SudokuElement.VALUE_MIN - 1; i < SudokuElement.VALUE_MAX; i++) {

            int[] howManyNumbersinOneDimension = new int[SudokuElement.VALUE_MAX];
            int[] howManyNumbersinOneDimension2 = howManyNumbersinOneDimension.clone();

            for (int k = SudokuElement.VALUE_MIN - 1; k < SudokuElement.VALUE_MAX; k++) {
                for (int jj = SudokuElement.VALUE_MIN - 1; jj < SudokuElement.VALUE_MAX; jj++) {
                    if (getSudokuBoardPossibleValues(i, jj).contains(k + 1)) {
                        howManyNumbersinOneDimension2[k]++;
                    }
                }
            }
            for (int k = SudokuElement.VALUE_MIN - 1; k < SudokuElement.VALUE_MAX; k++) {
                for (int j = SudokuElement.VALUE_MIN - 1; j < SudokuElement.VALUE_MAX; j++) {

                    if ((howManyNumbersinOneDimension2[k] == 1) && getSudokuBoardPossibleValues(i, j).contains(k + 1)) {
                        setSudokuBoardValue(i, j, k + 1);
                    }
                }
            }
        }


    }


    private SudokuElement getSudokuElement(int i, int j) {
        return sudokuBoard.getSudokuRowList().get(j).getSudokuRowElements().get(i);
    }


    private void blockAssigning() {

        for (int i = SudokuElement.VALUE_MIN - 1; i < SudokuElement.VALUE_MAX; i++) {
            for (int j = 0; j < SudokuElement.VALUE_MAX; j++) {

                int whichBlock = (i / SudokuElement.GAME_SIZE) * 10 + (j / SudokuElement.GAME_SIZE);
                switch (whichBlock) {
                    case 0:
                        getSudokuElement(i, j).setBlockNumber(0);
                        break;
                    case 1:
                        getSudokuElement(i, j).setBlockNumber(1);
                        break;
                    case 2:
                        getSudokuElement(i, j).setBlockNumber(2);
                        break;
                    case 10:
                        getSudokuElement(i, j).setBlockNumber(3);
                        break;
                    case 11:
                        getSudokuElement(i, j).setBlockNumber(4);
                        break;
                    case 12:
                        getSudokuElement(i, j).setBlockNumber(5);
                        break;
                    case 20:
                        getSudokuElement(i, j).setBlockNumber(6);
                        break;
                    case 21:
                        getSudokuElement(i, j).setBlockNumber(7);
                        break;
                    case 22:
                        getSudokuElement(i, j).setBlockNumber(8);
                        break;
                }

            }
        }
    }

    private int getBlockNumber(int i, int j) {
        return getSudokuElement(i, j).getBlockNumber();
    }

    private void solveBlock() {
        for (int i = SudokuElement.VALUE_MIN - 1; i < SudokuElement.VALUE_MAX; i++) {
            for (int j = SudokuElement.VALUE_MIN - 1; j < SudokuElement.VALUE_MAX; j++) {
                if (getSudokuBoardValue(i, j) != SudokuElement.EMPTY) {
                    sudokuBoard.getBlockPossibleValuesList().get(getBlockNumber(i, j)).add(getSudokuBoardValue(i, j));
                }
            }
        }

        for (int i = SudokuElement.VALUE_MIN - 1; i < SudokuElement.VALUE_MAX; i++) {
            for (int j = SudokuElement.VALUE_MIN - 1; j < SudokuElement.VALUE_MAX; j++) {
                int quantityPossibleValuesBefore = getSudokuBoardPossibleValues(i, j).size();
                getSudokuBoardPossibleValues(i, j).removeAll(sudokuBoard.getBlockPossibleValuesList().get(getBlockNumber(i, j)));
                int quantityPossibleValuesAfter = getSudokuBoardPossibleValues(i, j).size();
                if (quantityPossibleValuesAfter != quantityPossibleValuesBefore) {
                    anyChange = true;
                }

            }
        }

        for (int i = SudokuElement.VALUE_MIN - 1; i < SudokuElement.VALUE_MAX; i++) {
            for (int j = SudokuElement.VALUE_MIN - 1; j < SudokuElement.VALUE_MAX; j++) {

                if (getSudokuBoardValue(i, j) == SudokuElement.EMPTY) {

                    if (getSudokuBoardPossibleValues(i, j).size() == 1) {
                        int onlyPossibleValue = SudokuElement.EMPTY;
                        for (int value : getSudokuBoardPossibleValues(i, j)) {
                            onlyPossibleValue = value;
                        }
                        setSudokuBoardValue(i, j, onlyPossibleValue);

                    }

                }
            }


        }

    }


    private void solveBlock2() {

        for (int k = SudokuElement.VALUE_MIN - 1; k < SudokuElement.VALUE_MAX; k++) {

            int[][] howManyNumbersinOneDimension = new int[SudokuElement.VALUE_MAX][];

            for (int i = SudokuElement.VALUE_MIN - 1; i < SudokuElement.VALUE_MAX; i++) {
                howManyNumbersinOneDimension[i] = new int[SudokuElement.VALUE_MAX];
            }

            int[][] howManyNumbersinOneDimension2 = howManyNumbersinOneDimension.clone();

            for (int i = SudokuElement.VALUE_MIN - 1; i < SudokuElement.VALUE_MAX; i++) {
                for (int j = SudokuElement.VALUE_MIN - 1; j < SudokuElement.VALUE_MAX; j++) {
                    if (getSudokuBoardPossibleValues(i, j).contains(k + 1)) {
                        howManyNumbersinOneDimension2[k][getSudokuElement(i, j).getBlockNumber()]++;
                    }
                }
            }

            for (int i = SudokuElement.VALUE_MIN - 1; i < SudokuElement.VALUE_MAX; i++) {
                for (int j = SudokuElement.VALUE_MIN - 1; j < SudokuElement.VALUE_MAX; j++) {

                    if ((howManyNumbersinOneDimension2[k][getSudokuElement(i, j).getBlockNumber()] == 1) && getSudokuBoardPossibleValues(i, j).contains(k + 1)) {
                        setSudokuBoardValue(i, j, k + 1);
                    }
                }
            }
        }

    }

    public void solveSudoku() throws CloneNotSupportedException {

        solveRow();
        solveRow2();
        solveColumn();
        solveColumn2();
        solveBlock();
        solveBlock2();

        if (!anyChange) {
            guess();
            guessIterationCounter++;
        }

        anyChange = false;
    }

    private boolean isSolved() {
        boolean isSolved = true;
        for (int i = SudokuElement.VALUE_MIN - 1; i < SudokuElement.VALUE_MAX; i++) {
            for (int j = SudokuElement.VALUE_MIN - 1; j < SudokuElement.VALUE_MAX; j++) {
                if (getSudokuBoardValue(i, j) == SudokuElement.EMPTY) {
                    isSolved = false;
                }
            }
        }
        return isSolved;
    }

    public void startSudoku() throws CloneNotSupportedException {
        blockAssigning();

        DataInput dataInput = new DataInput();
        dataInput.fillCells(this);

        while (!isSolved() && check.isThereSolution(sudokuBoard)) {
            solveSudoku();
        }
        if (isSolved()) {
            System.out.println("The game was " + check.checkDifficultyForSudoku(guessIterationCounter));
        }

    }

    public boolean resolveSudoku() {
        return check.resolve();
    }

    private void guess() throws CloneNotSupportedException {

        for (int i = SudokuElement.VALUE_MIN - 1; i < SudokuElement.VALUE_MAX; i++) {
            for (int j = SudokuElement.VALUE_MIN - 1; j < SudokuElement.VALUE_MAX; j++) {
                if (getSudokuBoardValue(i, j) == SudokuElement.EMPTY) {
                    if (getSudokuBoardPossibleValues(i, j).toArray().length == 0) {
                        if (backtrack.size() > 0) {
                            SudokuState badState = backtrack.pop();
                            this.sudokuBoard = badState.getSudokuBoard();
                            getSudokuElement(badState.getI(), badState.getJ()).getPossibleValues().remove(badState.getGuessedValue());

                        }
                    } else {
                        backtrack.push(new SudokuState(this.sudokuBoard.deepCopy(), i, j, (int) getSudokuBoardPossibleValues(i, j).toArray()[0]));
                        setSudokuBoardValue(i, j, (int) getSudokuBoardPossibleValues(i, j).toArray()[0]);
                    }
                    anyChange = true;
                    j = 9;
                    i = 9;


                }

            }

        }

    }
}
