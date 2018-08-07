package com.kodilla.sudoku;

import java.util.*;

public class Check {

    public boolean isSudokuConsistent(SudokuBoard sudokuBoard, int x, int y, int value) {

        boolean result = true;
        int blockNumber = sudokuBoard.getBlockNumber(x, y);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ((i == x)
                        || (j == y)
                        || (blockNumber == sudokuBoard.getBlockNumber(i, j))) {
                    if (sudokuBoard.getSudokuBoardValue(i, j) == value) {
                        System.out.println("Value=" + value + " in the row=" + (y + 1) + " and column=" + (x + 1) + " would make sudoku inconsistent." +
                                "\nPlease use another data");
                        return false;
                    }
                }
            }
        }

        return result;
    }


    public boolean isThereSolution(SudokuBoard sudokuBoard) {

        boolean result = true;
        List<Set<Integer>> consistencyXList = new ArrayList<Set<Integer>>();
        List<Set<Integer>> consistencyYList = new ArrayList<Set<Integer>>();
        List<Set<Integer>> consistencyBlockList = new ArrayList<Set<Integer>>();

        for (int i = 0; i < 9; i++) {
            consistencyXList.add(new HashSet<>());
            consistencyYList.add(new HashSet<>());
            consistencyBlockList.add(new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudokuBoard.getSudokuBoardValue(i, j) != -1) {
                    if (consistencyXList.get(i).contains(sudokuBoard.getSudokuBoardValue(i, j))
                            || consistencyYList.get(j).contains(sudokuBoard.getSudokuBoardValue(i, j))
                            || consistencyBlockList.get(sudokuBoard.getBlockNumber(i, j)).contains(sudokuBoard.getSudokuBoardValue(i, j))) {
                        result = false;
                    }
                    consistencyXList.get(i).add(sudokuBoard.getSudokuBoardValue(i, j));
                    consistencyYList.get(j).add(sudokuBoard.getSudokuBoardValue(i, j));
                    consistencyBlockList.get(sudokuBoard.getBlockNumber(i, j)).add(sudokuBoard.getSudokuBoardValue(i, j));
                }

            }
        }
        if (result == false)
            System.out.println("This Sudoku has no solution");
        return result;
    }

    public boolean isElementInputRightRange(int x, int y, int value) {

        boolean result = true;
        if (x < SudokuElement.VALUE_MIN || x > SudokuElement.VALUE_MAX
                || y < SudokuElement.VALUE_MIN || y > SudokuElement.VALUE_MAX
                || value < SudokuElement.VALUE_MIN || value > SudokuElement.VALUE_MAX) {
            System.out.println("Given data to be writen in sudoku board are beyond the limits. Please rewrite it");
            return false;
        }


        return result;
    }

    public String checkDifficultyForSudoku(int guessIterationCounter) {

        String result = "";

        switch (guessIterationCounter / 5) {
            case 0:
                result = "Easy";
                break;
            case 1:
                result = "Intermediate";
                break;
            default:
                result = "Advanced";
                break;
        }

        return result;
    }

    public boolean resolve() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Do you want solve another sudoku?[Y/N]");
            String answer = scanner.nextLine();

            switch (answer) {
                case "N":
                    return true;
                case "Y":
                    return false;
            }
        }

    }
}
