package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedian(){
        //Given
        Set<Book> bookSet=new HashSet<>();
        bookSet.add(new Book("Agatha Christie","The Secret of Chimneys",1925,"IBN 234222"));
        bookSet.add(new Book("Agatha Christie","The Big Four",1927,"IBN 234223"));
        bookSet.add(new Book("Agatha Christie","The ABC Murders",1936,"IBN 234224"));
        bookSet.add(new Book("Agatha Christie","N or M",1941,"IBN 234225"));
        bookSet.add(new Book("Agatha Christie","Five little pigs lub Murder in Retrospect",1942,"IBN 234226"));
        bookSet.add(new Book("Agatha Christie","The Clocks",1963,"IBN 234227"));
        bookSet.add(new Book("Agatha Christie","A Caribbean Mystery",1964,"IBN 234228"));
        MedianAdapter medianAdapter=new MedianAdapter();
        //When
        int medianResultOdd=medianAdapter.publicationYearMedian(bookSet);
        bookSet.add(new Book("Agatha Christie","Sleeping Murder",1976,"IBN 234228"));
        int medianResultEven=medianAdapter.publicationYearMedian(bookSet);
        //Then
        Assert.assertEquals(1941,medianResultOdd);
        Assert.assertEquals(1942,medianResultEven);
    }
}
