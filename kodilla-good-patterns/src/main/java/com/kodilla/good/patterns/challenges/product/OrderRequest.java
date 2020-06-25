package com.kodilla.good.patterns.challenges.product;

public class OrderRequest {
    private String User;
    private String item;


    public OrderRequest(String user, String item) {
        User = user;
        this.item = item;
    }

    public String getUser() {
        return User;
    }

    public String getItem() {
        return item;
    }
}
