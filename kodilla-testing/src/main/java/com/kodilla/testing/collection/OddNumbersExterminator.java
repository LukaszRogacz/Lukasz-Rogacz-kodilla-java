package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.lang.*;

public class OddNumbersExterminator {
    private ArrayList<Integer> oddNumbersList;

    public OddNumbersExterminator(){
        oddNumbersList=new ArrayList<Integer>();
    }

    public ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {
        for (Integer myInteger : numbers) {
            if ((myInteger % 2) == 0) {
                oddNumbersList.add(myInteger);
            }
        }
        return oddNumbersList;
    }


}
