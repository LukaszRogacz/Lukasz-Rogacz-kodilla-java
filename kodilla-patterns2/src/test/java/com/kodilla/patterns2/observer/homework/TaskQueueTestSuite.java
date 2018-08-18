package com.kodilla.patterns2.observer.homework;

import org.junit.Assert;
import org.junit.Test;

public class TaskQueueTestSuite {
    @Test
    public void TaskQueuetest() {
        //Given
        Task task1 = new Task("task1", "description1");
        Task task2 = new Task("task2", "description2");
        Task task3 = new Task("task3", "description3");
        Task task4 = new Task("task4", "description4");
        Task task5 = new Task("task5", "description5");
        Task task6 = new Task("task6", "description6");
        Task task7 = new Task("task7", "description7");
        Task task8 = new Task("task8", "description8");
        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");
        Mentor mentor1 = new Mentor("mentor1");
        Mentor mentor2 = new Mentor("mentor2");
        Mentor mentor3 = new Mentor("mentor3");
        user1.getTaskQueue().registerObserver(mentor1);
        user2.getTaskQueue().registerObserver(mentor1);
        user3.getTaskQueue().registerObserver(mentor2);
        user1.getTaskQueue().registerObserver(mentor3);
        user2.getTaskQueue().registerObserver(mentor3);
        user3.getTaskQueue().registerObserver(mentor3);
        //When
        user1.getTaskQueue().addTask(task1);
        user1.getTaskQueue().addTask(task2);
        user1.getTaskQueue().addTask(task3);
        user2.getTaskQueue().addTask(task4);
        user2.getTaskQueue().addTask(task5);
        user2.getTaskQueue().addTask(task6);
        user3.getTaskQueue().addTask(task7);
        user3.getTaskQueue().addTask(task8);
        user1.getTaskQueue().removeTask();
        user2.getTaskQueue().removeTask();
        user3.getTaskQueue().removeTask();
        //Then
        Assert.assertEquals(6, mentor1.getCountAdd());
        Assert.assertEquals(2, mentor2.getCountAdd());
        Assert.assertEquals(8, mentor3.getCountAdd());
        Assert.assertEquals(2, mentor1.getCountRemove());
        Assert.assertEquals(1, mentor2.getCountRemove());
        Assert.assertEquals(3, mentor3.getCountRemove());

    }
}
