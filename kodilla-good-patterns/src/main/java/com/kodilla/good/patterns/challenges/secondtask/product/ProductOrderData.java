package com.kodilla.good.patterns.challenges.secondtask.product;

public class ProductOrderData {
    private String item;
    private boolean bought;

    public ProductOrderData(String item, boolean bought) {
        this.item = item;
        this.bought = bought;
    }

    public String getStatus() {
        if (bought) {
            return item + " jest zakupiony i w trakcie realizacji";
        } else {
            return "Przedmiot " + item + " nie został zakupiony";
        }
    }

}
