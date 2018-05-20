package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype{
    private String name;
    private Set<Book> books = new HashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Library shallowCopy() throws CloneNotSupportedException{
        return (Library) super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException{
        Library clonedLibrary=(Library) super.clone();
        clonedLibrary.books=new HashSet<>();
        for (Book tempBook: books){
            clonedLibrary.books.add(tempBook);
        }
        return clonedLibrary;
    }

    public String toString(){
        String s=name;
        s+="\n";
        for (Book tempBook: books){
            s+=tempBook;
        }
        return s;
    }

}