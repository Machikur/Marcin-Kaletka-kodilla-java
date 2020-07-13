package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void createDrivingTaskTest() {
        //given
        TaskFactory taskFactory = new TaskFactory();
        Task taskOne = taskFactory.createTask("DRIVING_TASK");

        //when
        boolean wasExecute = taskOne.isTaskExecuted();
        taskOne.executeTask();

        //then
        Assert.assertEquals("Driving job", taskOne.getTaskName());
        Assert.assertFalse(wasExecute);
        Assert.assertTrue(taskOne.isTaskExecuted());
    }

    @Test
    public void createPaintingTaskTest() {
        //given
        TaskFactory taskFactory = new TaskFactory();
        Task taskOne = taskFactory.createTask("PAINTING_TASK");

        //when
        boolean wasExecute = taskOne.isTaskExecuted();
        taskOne.executeTask();

        //then
        Assert.assertEquals("Painting in London", taskOne.getTaskName());
        Assert.assertFalse(wasExecute);
        Assert.assertTrue(taskOne.isTaskExecuted());
    }

    @Test
    public void createShoppingTaskTest() {
        //given
        TaskFactory taskFactory = new TaskFactory();
        Task taskOne = taskFactory.createTask("SHOPPING_TASK");

        //when
        boolean wasExecute = taskOne.isTaskExecuted();
        taskOne.executeTask();

        //then
        Assert.assertEquals("shopping for me", taskOne.getTaskName());
        Assert.assertFalse(wasExecute);
        Assert.assertTrue(taskOne.isTaskExecuted());
    }

    @Test
    public void testNonExistingTaskFactory() {
        //given
        TaskFactory taskFactory = new TaskFactory();

        //when
        Task taskOne = taskFactory.createTask("NO_TASK");

        //then
        Assert.assertNull(taskOne);
    }
}
