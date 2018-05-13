package com.kodilla.spring.portfolio;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {

    @Test
    public void testTaskAdd(){
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board=context.getBean(Board.class);
        //When
        board.getDoneList().addTask("Done task");
        board.getInProgressList().addTask("In progress task");
        board.getToDoList().addTask("To do task");

        String taskNameToDoList=board.getToDoList().getTasks().get(0);
        String taskNameInProgressList=board.getInProgressList().getTasks().get(0);
        String taskNameDoneList=board.getDoneList().getTasks().get(0);

        //Then

        Assert.assertEquals("Done task",taskNameDoneList);
        Assert.assertEquals("In progress task",taskNameInProgressList);
        Assert.assertEquals("To do task",taskNameToDoList);





    }
}
