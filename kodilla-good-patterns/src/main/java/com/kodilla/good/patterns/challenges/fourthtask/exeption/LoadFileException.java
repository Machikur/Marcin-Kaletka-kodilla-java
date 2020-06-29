package com.kodilla.good.patterns.challenges.fourthtask.exeption;

public class LoadFileException extends Exception {

    public LoadFileException() {
        System.out.println("Błąd ładowania danych");
    }
}
