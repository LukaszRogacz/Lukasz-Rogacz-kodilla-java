package com.kodilla.sudoku;

import java.util.Scanner;

public class DataInput {

    Scanner scanner = MyScanner.getInstance();

    private int selectInputMethod() {

        while (true) {

            System.out.println("Select method of writing data(999 in row value ends inputting data)\n1. Each data type separately" +
                    "\n2. Each cell separatelly divided by comma: e.g. 1,2,3,4,5,6 " +
                    "(Value 3 in first row in second column, value 6 in forth row in sixth column)");

            switch (scanner.nextLine()) {
                case "1":
                    return 1;
                case "2":
                    return 2;
            }
        }
    }

    public void fillCells(SudokuGame sudokuGame) {

        int methodOfWritingData = selectInputMethod();

        int whatRow = 0;
        int whatColumn = 0;
        int whatValue = 0;

        Check check = new Check();

        while (whatRow != 999 && methodOfWritingData == 1) {

            try {
                System.out.println("What row?");
                whatRow = Integer.parseInt(scanner.nextLine());
                System.out.println("What column?");
                whatColumn = Integer.parseInt(scanner.nextLine());
                System.out.println("What value?");
                whatValue = Integer.parseInt(scanner.nextLine());

                if (check.isElementInputRightRange(whatColumn, whatRow, whatValue)
                        && whatRow != 999
                        && check.isSudokuConsistent(sudokuGame.getSudokuBoard(), whatColumn - 1, whatRow - 1, whatValue)) {
                    sudokuGame.setSudokuBoardValue(whatColumn - 1, whatRow - 1, whatValue);

                }
            } catch (Exception e) {

                System.out.println("Please pay attention while inputting data" + e);
                whatRow = 0;
                whatColumn = 0;
                whatValue = 0;

            }
        }


        while (whatRow != 999 && methodOfWritingData == 2) {
            System.out.println("What row,column,value,row,column,value,... ?");
            String whatRowsColumnsValues = scanner.nextLine();

            String[] arrayRowColumnValue = whatRowsColumnsValues.split(",");

            for (int i = 0; i < arrayRowColumnValue.length; i = i + 3) {

                try {
                    whatRow = Integer.parseInt(arrayRowColumnValue[i]);
                    whatColumn = Integer.parseInt(arrayRowColumnValue[i + 1]);
                    whatValue = Integer.parseInt(arrayRowColumnValue[i + 2]);
                } catch (Exception e) {
                    whatRow = 999;
                    System.out.println("Problems in data,please be careful while writing data");
                }


                if (check.isElementInputRightRange(whatColumn, whatRow, whatValue)
                        && whatRow != 999
                        && check.isSudokuConsistent(sudokuGame.getSudokuBoard(), whatColumn - 1, whatRow - 1, whatValue)) {
                    sudokuGame.setSudokuBoardValue(whatColumn - 1, whatRow - 1, whatValue);

                }
                if (whatRow == 999) {
                    break;
                }

            }
        }

    }
}
