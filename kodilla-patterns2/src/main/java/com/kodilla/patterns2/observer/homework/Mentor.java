package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String name;
    private int countAdd;
    private int countRemove;

    public Mentor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void updateAdd(TaskQueue taskQueue) {
        System.out.println("Task in " + taskQueue.getName() + " for " + name + " was added");
        countAdd++;
    }

    @Override
    public void updateRemove(TaskQueue taskQueue) {
        System.out.println("Task in " + taskQueue.getName() + " for " + name + " was removed");
        countRemove++;
    }

    public int getCountAdd() {
        return countAdd;
    }

    public int getCountRemove() {
        return countRemove;
    }
}
