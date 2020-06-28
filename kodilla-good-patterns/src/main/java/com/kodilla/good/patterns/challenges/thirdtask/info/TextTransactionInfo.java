package com.kodilla.good.patterns.challenges.thirdtask.info;

public class TextTransactionInfo implements Information {

    @Override
    public String getTransactionInfo(String localization, boolean accepted, int amount) {
        if (accepted) {
            return "Udało się przeprowadzić transakcje, produkt w ilości: " + amount + " trafi do " + localization;
        } else {
            return "Nie udało się zrealizować zamówienia";
        }
    }
}
