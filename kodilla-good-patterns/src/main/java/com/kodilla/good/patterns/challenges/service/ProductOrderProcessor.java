package com.kodilla.good.patterns.challenges.service;

import java.util.ArrayList;
import java.util.List;

public class ProductOrderProcessor implements OrderProcessor {

    //tymczasowe listy udające baze danych
    private List<String> itemList = new ArrayList<>();
    private List<String> userList = new ArrayList<>();


    @Override
    public boolean buy(String user, String item) {
        if (itemList.contains(item) && userList.contains(user)) {
            return true;
        } else {
            return false;
        }
    }

}
