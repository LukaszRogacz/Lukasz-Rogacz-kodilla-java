package com.kodilla.patterns.factory.tasks;

import java.util.Random;

public class ShoppingTask implements Task {

    private String taskName;
    private String whatToBuy;
    private double quantity;

    public ShoppingTask(String taskName, String whatToBuy, double quantity){
        this.taskName=taskName;
        this.whatToBuy=whatToBuy;
        this.quantity=quantity;
    }

    private double quantityDone=0;

    @Override
    public double executeTask() {

        Random random=new Random();
        quantityDone+=random.nextDouble();
        if(quantityDone>=quantity){
            quantityDone=quantity;
        }
        System.out.println("Task done in "+quantityDone/quantity*100+" %");
        return quantityDone/quantity;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        if(quantityDone==quantity){
            return true;
        }else{
            return false;
        }
    }

}
