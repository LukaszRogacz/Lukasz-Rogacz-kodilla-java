package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TaskQueue implements Observable {

    Queue<Task> taskQueue = new ArrayDeque<>();
    List<Observer> observers = new ArrayList<>();
    private final String name;

    public TaskQueue(final String name) {
        this.name = name;
    }

    public void addTask(Task task) {
        taskQueue.offer(task);
        notifyObserversAdd();
    }

    public void removeTask(){
        if(!taskQueue.isEmpty()) {
            taskQueue.poll();
            notifyObserversRemove();
        }else {
            System.out.println("Task Queue is empty");
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserversAdd() {
        for (Observer observer : observers) {
            observer.updateAdd(this);
        }
    }
    @Override
    public void notifyObserversRemove() {
        for (Observer observer : observers) {
            observer.updateRemove(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public Queue<Task> getTaskQueue() {
        return taskQueue;
    }

    public String getName() {
        return name;
    }
}
