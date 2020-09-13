package com.kodilla.patterns2.observer.forum.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class KodillaStudent implements Student {
    private final Deque<String> taskQueue;
    private final String name;
    private List<Mentor> mentorList;

    public KodillaStudent(String name) {
        this.taskQueue = new ArrayDeque<>();
        this.name = name;
        mentorList = new ArrayList<>();
    }

    public void addTask(String task) {
        taskQueue.push(task);
        notifyMentor(task);
    }


    @Override
    public void registerMentor(Mentor mentor) {
        mentorList.add(mentor);
    }

    @Override
    public void notifyMentor(String task) {
        for (Mentor mentor : mentorList) {
            mentor.upgrade(task, name);
        }
    }

    @Override
    public void removeMentor(Mentor mentor) {
        mentorList.remove(mentorList);
    }

    public String getName() {
        return name;
    }
}
