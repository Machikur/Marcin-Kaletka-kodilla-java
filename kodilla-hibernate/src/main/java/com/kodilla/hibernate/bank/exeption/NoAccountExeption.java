package com.kodilla.hibernate.bank.exeption;

public class NoAccountExeption extends Exception {
    public NoAccountExeption(String message) {
        super(message);
    }
}
