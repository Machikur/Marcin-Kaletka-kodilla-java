package com.kodilla.patterns2.observer.forum.homework;

public class KodillaMentor implements Mentor {
    private final String name;
    private int taskCounter;

    public KodillaMentor(String name) {
        this.name = name;
    }

    @Override
    public void upgrade(String task, String name) {
        System.out.println("There is a new task: " + task + ", from student named " + name);
        taskCounter++;
    }

    public String getName() {
        return name;
    }

    public int getTaskCounter() {
        return taskCounter;
    }
}
