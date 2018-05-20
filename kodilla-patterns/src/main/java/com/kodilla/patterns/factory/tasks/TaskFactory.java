package com.kodilla.patterns.factory.tasks;

public class TaskFactory {

    public static final String SHOPPING_TASK = "SHOPPING TASK";
    public static final String PAINTING_TASK = "PAINTING TASK";
    public static final String DRIVING_TASK = "DRIVING TASK";

    public final Task makeTask(final String taskClass) {

        switch (taskClass) {
            case SHOPPING_TASK:
                return new ShoppingTask("kup marchewke", "marchew", 2.0);
            case PAINTING_TASK:
                return new PaintingTask("pomaluj sufit", "biały", "sufit");
            case DRIVING_TASK:
                return new DrivingTask("przjażdżka", "Gdańsk", "samochód");
            default:
                return null;
        }

    }

}
