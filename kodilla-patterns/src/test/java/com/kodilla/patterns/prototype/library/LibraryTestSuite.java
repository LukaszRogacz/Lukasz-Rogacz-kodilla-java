package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {
    @Test
    public void testGetBooks(){
        //Given
        Library library=new Library("moja biblioteczka");
        LocalDate localDate1=LocalDate.of(1911,1,1);
        Book book1=new Book("W pustyni i puszczy","Henryk Sienkiewicz",localDate1);
        LocalDate localDate2=LocalDate.of(1895,1,1);
        Book book2=new Book("Faraon","Bolesław Prus",localDate2);
        LocalDate localDate3=LocalDate.of(1934,1,1);
        Book book3=new Book("Morderstwo w Orient Expressie","Agatha Christie",localDate3);

        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        Library shallowCopyLibrary=null;
        try{
            shallowCopyLibrary=library.shallowCopy();
            shallowCopyLibrary.setName("moja płytka biblioteczka");
        }
        catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        Library deepCopyLibrary=null;
        try{
            deepCopyLibrary=library.deepCopy();
            deepCopyLibrary.setName("moja głęboka biblioteczka");
        }
        catch (CloneNotSupportedException e){
            System.out.println(e);
        }

        //When

        shallowCopyLibrary.getBooks().remove(book1);
        shallowCopyLibrary.getBooks().remove(book2);
        deepCopyLibrary.getBooks().remove(book3);

        //Then

        System.out.println(library);
        System.out.println(shallowCopyLibrary);
        System.out.println(deepCopyLibrary);
        Assert.assertEquals(1,library.getBooks().size());
        Assert.assertEquals(1,shallowCopyLibrary.getBooks().size());
        Assert.assertEquals(2,deepCopyLibrary.getBooks().size());
        Assert.assertNotEquals(library,deepCopyLibrary.getBooks());
        Assert.assertEquals(shallowCopyLibrary.getBooks(),library.getBooks());

    }
}
