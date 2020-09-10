package com.kodilla.patterns2.facade;

public class Item {
    private final Long id;
    private final double qty;

    public Long getId() {
        return id;
    }

    public double getQty() {
        return qty;
    }

    public Item(Long id, double qty) {
        this.id = id;
        this.qty = qty;
    }
}
