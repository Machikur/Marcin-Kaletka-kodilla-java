package com.kodilla.good.patterns.challenges.secondtask.product;

public class OrderProductRequest {
    private String user;
    private String item;


    public OrderProductRequest(String user, String item) {
        this.user = user;
        this.item = item;
    }

    public String getUser() {
        return user;
    }

    public String getItem() {
        return item;
    }
}
