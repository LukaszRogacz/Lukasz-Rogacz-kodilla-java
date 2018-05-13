package com.kodilla.spring.portfolio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
public class BoardConfig {

    @Autowired
    @Qualifier("toDoList")
    TaskList getToDoList;

    @Autowired
    @Qualifier("inProgressList")
    TaskList getInProgressList;

    @Autowired
    @Qualifier("doneList")
    TaskList getDoneList;

    @Bean(name = "toDoList")
    @Scope("prototype")
    public TaskList getToDoList() {
        return new TaskList();
    }

    @Bean(name = "inProgressList")
    @Scope("prototype")
    public TaskList getInProgressList() {
        return new TaskList();
    }

    @Bean(name = "doneList")
    @Scope("prototype")
    public TaskList getDoneList() {
        return new TaskList();
    }

    @Bean
    public Board getBoard() {
        return new Board(getToDoList, getInProgressList, getDoneList);
    }
}
