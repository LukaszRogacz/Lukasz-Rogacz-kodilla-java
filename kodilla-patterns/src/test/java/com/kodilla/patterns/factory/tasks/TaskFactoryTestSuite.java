package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void testFactoryShopping(){
        //Given
        TaskFactory taskFactory=new TaskFactory();
        //When
        Task shopping=taskFactory.makeTask(TaskFactory.SHOPPING_TASK);

        shopping.executeTask();
        shopping.executeTask();
        shopping.executeTask();


        boolean taksIsDone;
        if (shopping.executeTask()==1){
            taksIsDone=true;
        }
        else{
            taksIsDone=false;
        }
        System.out.println("Is task executed="+shopping.isTaskExecuted());

        //Then
        Assert.assertEquals("kup marchewke", shopping.getTaskName());
        Assert.assertEquals(taksIsDone, shopping.isTaskExecuted());
    }

    @Test
    public void testFactoryPainting(){
        //Given
        TaskFactory taskFactory=new TaskFactory();
        //When
        Task painting=taskFactory.makeTask(TaskFactory.PAINTING_TASK);

        painting.executeTask();
        painting.executeTask();
        painting.executeTask();


        boolean taksIsDone;
        if (painting.executeTask()==1){
            taksIsDone=true;
        }
        else{
            taksIsDone=false;
        }
        System.out.println("Is task executed="+painting.isTaskExecuted());

        //Then
        Assert.assertEquals("pomaluj sufit", painting.getTaskName());
        Assert.assertEquals(taksIsDone, painting.isTaskExecuted());
    }

    @Test
    public void testFactoryDriving(){
        //Given
        TaskFactory taskFactory=new TaskFactory();
        //When
        Task driving=taskFactory.makeTask(TaskFactory.DRIVING_TASK);

        driving.executeTask();
        driving.executeTask();
        driving.executeTask();


        boolean taksIsDone;
        if (driving.executeTask()==1){
            taksIsDone=true;
        }
        else{
            taksIsDone=false;
        }
        System.out.println("Is task executed="+driving.isTaskExecuted());

        //Then
        Assert.assertEquals("przjażdżka", driving.getTaskName());
        Assert.assertEquals(taksIsDone, driving.isTaskExecuted());
    }
}
