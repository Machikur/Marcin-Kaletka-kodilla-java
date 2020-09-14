package com.kodilla.patterns2.observer.homework;


public interface Student {
    void registerMentor(Mentor mentor);

    void notifyMentor(String task);

    void removeMentor(Mentor mentor);
}
