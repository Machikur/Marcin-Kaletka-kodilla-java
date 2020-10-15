package com.kodilla.patterns2.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private final List<Item> items = new ArrayList<>();
    private final Long orderID;
    private final Long userID;
    private ProductService productService;
    private boolean isPaid;
    private boolean isVeryfied;
    private boolean isSubmitted;

    public Order(Long orderID, Long userID, ProductService productService) {
        this.orderID = orderID;
        this.userID = userID;
        this.productService = productService;
    }

    public BigDecimal calculateValue() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Item item : items) {
            sum = sum.add(productService.getPrice(item.getId()).multiply(BigDecimal.valueOf(item.getQty())));
        }
        return sum;
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    public List<Item> getItems() {
        return items;
    }

    public Long getOrderID() {
        return orderID;
    }

    public Long getUserID() {
        return userID;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public boolean isVeryfied() {
        return isVeryfied;
    }

    public void setVeryfied(boolean veryfied) {
        isVeryfied = veryfied;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public void setSubmitted(boolean submitted) {
        isSubmitted = submitted;
    }
}
