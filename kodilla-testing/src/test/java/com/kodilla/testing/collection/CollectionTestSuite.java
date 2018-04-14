package com.kodilla.testing.collection;

import org.junit.*;

import java.util.ArrayList;

public class CollectionTestSuite {
    int whichTest = 0;

    @Before
    public void before() {
        if ((whichTest % 2) == 0) {
            System.out.println("Test Case: begin of : testOddNumbersExterminatorEmptyList");
        }
        if ((whichTest % 2) == 1) {
            System.out.println("Test Case: begin of : testOddNumbersExterminatorNormalList");
        }

    }

    @After
    public void after() {
        if ((whichTest % 2) == 0) {
            System.out.println("Test Case: end of : testOddNumbersExterminatorEmptyList");
        }
        if ((whichTest % 2) == 1) {
            System.out.println("Test Case: end of : testOddNumbersExterminatorNormalList");
        }
        whichTest++;
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //Given
        ArrayList<Integer> myList = new ArrayList<Integer>();
        //When
        OddNumbersExterminator oddList = new OddNumbersExterminator();
        ArrayList<Integer> result = oddList.exterminate(myList);
        //Then
        Assert.assertTrue(result.isEmpty());

    }

    @Test
    public void testOddNumbersExterminatorNormalList() {
        //Given
        ArrayList<Integer> myList = new ArrayList<Integer>();
        myList.add(1);
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        //When
        OddNumbersExterminator oddList = new OddNumbersExterminator();
        ArrayList<Integer> result = oddList.exterminate(myList);
        //Then
        Integer assertTable[] = new Integer[2];
        assertTable[0] = 2;
        assertTable[1] = 4;
        Assert.assertArrayEquals(assertTable, result.toArray());
    }
}
