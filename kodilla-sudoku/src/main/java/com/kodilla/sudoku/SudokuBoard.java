package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SudokuBoard implements Cloneable {


    private List<SudokuRow> sudokuRowList;
    private ArrayList<HashSet<Integer>> blockPossibleValuesList = new ArrayList<HashSet<Integer>>(9);

    public ArrayList<HashSet<Integer>> getBlockPossibleValuesList() {
        return blockPossibleValuesList;
    }

    private SudokuElement getSudokuElement(int i, int j) {
        return getSudokuRowList().get(j).getSudokuRowElements().get(i);
    }

    public int getBlockNumber(int i, int j) {
        return getSudokuElement(i, j).getBlockNumber();
    }

    public SudokuBoard() {
        this(SudokuElement.GAME_SIZE);
    }

    private SudokuBoard(int gameSize) {
        this.sudokuRowList = new ArrayList<>();
        for (int i = 1; i <= Math.pow(gameSize, 2); i++) {
            this.sudokuRowList.add(new SudokuRow(SudokuElement.GAME_SIZE));
        }
        for (int i = SudokuElement.VALUE_MIN - 1; i < SudokuElement.VALUE_MAX; i++) {
            blockPossibleValuesList.add(new HashSet<Integer>());
        }
    }

    public int getSudokuBoardValue(int x, int y) {
        return this.getSudokuRowList().get(y).getSudokuRowElements().get(x).getValue();
    }


    public SudokuBoard deepCopy() throws CloneNotSupportedException {

        SudokuBoard clonedSudokuBoard = (SudokuBoard) super.clone();

        clonedSudokuBoard.sudokuRowList = new ArrayList<>();
        ArrayList<HashSet<Integer>> clonedBlockPossibleValuesList = new ArrayList<HashSet<Integer>>(SudokuElement.GAME_SIZE);

        for (HashSet<Integer> hashSet : blockPossibleValuesList) {

            HashSet<Integer> clonedHashSet = new HashSet<>();

            for (Integer integer : hashSet) {

                clonedHashSet.add(integer);
            }

            clonedBlockPossibleValuesList.add(clonedHashSet);

        }

        for (SudokuRow sudokuRow : sudokuRowList) {

            SudokuRow clonedRow = new SudokuRow();


            for (SudokuElement sudokuElement : sudokuRow.getSudokuRowElements()) {

                SudokuElement clonedSudokuElement = new SudokuElement();

                Set<Integer> possibleValuesSet = new HashSet<>();

                for (Integer possibleValue : sudokuElement.getPossibleValues()) {
                    possibleValuesSet.add(possibleValue);
                }


                clonedSudokuElement.setValue(sudokuElement.getValue());
                clonedSudokuElement.setBlockNumber(sudokuElement.getBlockNumber());
                clonedSudokuElement.setPossibleValues(possibleValuesSet);

                clonedRow.getSudokuRowElements().add(clonedSudokuElement);

            }


            clonedSudokuBoard.sudokuRowList.add(clonedRow);
        }
        clonedSudokuBoard.blockPossibleValuesList = clonedBlockPossibleValuesList;
        return clonedSudokuBoard;
    }

    public List<SudokuRow> getSudokuRowList() {
        return sudokuRowList;
    }

    @Override
    public String toString() {
        String s = " _________________   _________________   _________________\n";

        for (int i = 0; i < sudokuRowList.size(); i++) {
            s += "|     |     |     | |     |     |     | |     |     |     |" + "\n";
            s += "|  ";
            for (int j = 0; j < sudokuRowList.get(i).getSudokuRowElements().size(); j++) {
                int valueTemp = sudokuRowList.get(i).getSudokuRowElements().get(j).getValue();
                if (valueTemp < 0) {
                    s += " ";
                } else {
                    s += valueTemp;
                }

                if ((((j + 1) % 3) == 0)
                        && ((j + 1) < 9)) {
                    s += "  | |  ";
                } else {
                    s += "  |  ";
                }
            }
            s = s + "\n";
            if ((((i + 1) % 3) == 0)
                    && ((i + 1) < 9)) {
                s += "|_____|_____|_____| |_____|_____|_____| |_____|_____|_____|\n";
                s += " _________________   _________________   _________________";
            } else {
                s += "|_____|_____|_____| |_____|_____|_____| |_____|_____|_____|";
            }

            s = s + "\n";
        }


        return s;
    }
}
