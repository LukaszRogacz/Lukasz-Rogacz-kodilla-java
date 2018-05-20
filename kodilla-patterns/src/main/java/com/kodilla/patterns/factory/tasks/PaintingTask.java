package com.kodilla.patterns.factory.tasks;

import java.util.Random;

public class PaintingTask implements Task {

    private String taskName;
    private String color;
    private String whatToPaint;

    public PaintingTask(String taskName, String color, String whatToPaint){
        this.taskName=taskName;
        this.color=color;
        this.whatToPaint=whatToPaint;
    }

    double paintingDone=0;


    @Override
    public double executeTask() {
        Random random=new Random();
        paintingDone+=random.nextDouble();
        if(paintingDone>=1){
            paintingDone=1;
        }
        System.out.println("Task done in "+paintingDone*100+" %");
        return paintingDone;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        if(paintingDone==1){
            return true;
        }else {
            return false;
        }
    }
}
