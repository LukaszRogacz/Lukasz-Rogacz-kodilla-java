package com.kodilla.patterns2.observer.homework;

public class Task {
    private final String name;
    private final String description;

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
