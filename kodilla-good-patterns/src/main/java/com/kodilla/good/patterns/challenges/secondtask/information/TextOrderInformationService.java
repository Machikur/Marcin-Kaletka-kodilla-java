package com.kodilla.good.patterns.challenges.secondtask.information;

public class TextOrderInformationService implements OrderInformationService {
    @Override
    public void inform(String user, String item) {
        System.out.println("Dziękujemy za zakup " + item + " panie/pani " + user);
    }
}
