package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.lang.*;

public class OddNumbersExterminator {
    

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {
        ArrayList<Integer> oddNumbersList = new ArrayList<Integer>();
        for (Integer myInteger : numbers) {
            if ((myInteger % 2) == 0) {
                oddNumbersList.add(myInteger);
            }
        }
        return oddNumbersList;
    }


}
