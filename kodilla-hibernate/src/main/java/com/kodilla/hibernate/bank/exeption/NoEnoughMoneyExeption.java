package com.kodilla.hibernate.bank.exeption;


public class NoEnoughMoneyExeption extends Exception {

    public NoEnoughMoneyExeption(String message) {
        super(message);
    }
}
