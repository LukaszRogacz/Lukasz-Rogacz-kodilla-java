package com.kodilla.patterns2.observer.homework;

public class User {
    private final TaskQueue taskQueue;
    private final String username;

    public User(String username) {
        this.taskQueue = new TaskQueue(username+ " task queue");
        this.username = username;
    }

    public TaskQueue getTaskQueue() {
        return taskQueue;
    }

    public String getUsername() {
        return username;
    }
}
