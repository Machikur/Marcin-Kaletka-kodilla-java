package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
    private static final String PAINTING_TASK = "PAINTING_TASK";
    private static final String SHOPPING_TASK = "SHOPPING_TASK";
    private static final String DRIVING_TASK = "DRIVING_TASK";

    public Task createTask(final String TypeOfTask) {
        switch (TypeOfTask) {
            case PAINTING_TASK:
                return new PaintingTask("Painting in London", "Blue", "Door");
            case SHOPPING_TASK:
                return new ShoppingTask("shopping for me", "butter", 25);
            case DRIVING_TASK:
                return new DrivingTask("Driving job", "London", "Car");
            default:
                return null;
        }
    }
}
