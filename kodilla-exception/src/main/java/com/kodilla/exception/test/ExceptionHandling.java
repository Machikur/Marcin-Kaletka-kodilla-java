package com.kodilla.exception.test;

public class ExceptionHandling {
    private SecondChallenge secondChallenge = new SecondChallenge();
    private int x = 2;
    private int y = 2;

    public void task() {
        try {
            String result = secondChallenge.probablyIWillThrowException(x, y);
            System.out.println(result);
        } catch (Exception x) {
            System.out.println("podano nieprawidłowe wartości");
        } finally {
            System.out.println("dziękujemy za skorzystanie z programu");
        }
    }
}
