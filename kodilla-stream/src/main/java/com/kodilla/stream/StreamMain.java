package com.kodilla.stream;


import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamMain {
    public static void main(String[] args) {
/*        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("text", a -> "ABC " + a);
        poemBeautifier.beautify("text", a -> a + " ABC");
        poemBeautifier.beautify("text", a -> a.toUpperCase());
        poemBeautifier.beautify("text", a -> "*** " + a + " ***");
        poemBeautifier.beautify("text", a -> "\" " + a + " \"");

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

        People.getList().stream()
                .forEach(System.out::println);

        People.getList().stream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);

        People.getList().stream()
                .map(String::toUpperCase)
                .forEach(s -> System.out.println(s));

        People.getList().stream()
                .filter(s -> s.length() > 11)
                .forEach(System.out::println);

        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(System.out::println);

        BookDirectory theBookDirectory = new BookDirectory();
        theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .forEach(System.out::println);

        BookDirectory theBookDirectory = new BookDirectory();
        List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toList());

        System.out.println("# elements: " + theResultListOfBooks.size());
        theResultListOfBooks.stream()
                .forEach(System.out::println);

        Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks); */


        Forum theForum=new Forum();
        Map <Integer, ForumUser> theResultForum=theForum.getUserList().stream()
                .filter(user-> user.getSex()=='M')
                .filter(user-> user.getPostQuantity()>0)
                .filter(user-> Period.between(user.getBirthDate(), LocalDate.now()).getYears()>=20)
                .collect(Collectors.toMap(ForumUser::getForumUserID,user -> user));

        theResultForum.entrySet().stream().forEach(System.out::println);
    }
}