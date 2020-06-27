package com.kodilla.good.patterns.challenges.thirdtask.product;

import java.util.Objects;

public class ProductData {
    private Product product;
    private int amount;

    public ProductData(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductData that = (ProductData) o;
        return amount == that.amount &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, amount);
    }

}
