package com.kodilla.patterns.factory.tasks;

import java.util.Random;

public class DrivingTask implements Task {

    private String taskName;
    private String where;
    private String using;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    private double drivingDone = 0;

    @Override
    public double executeTask() {
        Random random = new Random();
        drivingDone += random.nextDouble();
        if (drivingDone >= 1) {
            drivingDone = 1;
        }
        System.out.println("Task done in " + drivingDone * 100 + " %");
        return drivingDone;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        if (drivingDone == 1) {
            return true;
        } else {
            return false;
        }
    }
}
