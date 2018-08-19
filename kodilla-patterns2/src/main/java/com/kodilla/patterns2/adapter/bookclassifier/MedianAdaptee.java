package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookStatistics;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.Statistics;

import java.util.Map;

public class MedianAdaptee implements BookStatistics {
    @Override
    public int medianPublicationYear(Map<BookSignature, Book> books) {
        Statistics theProcessor=new Statistics();
        return theProcessor.medianPublicationYear(books);
    }

    @Override
    public int averagePublicationYear(Map<BookSignature, Book> books) {
        Statistics theProcessor=new Statistics();
        return theProcessor.averagePublicationYear(books);
    }
}
