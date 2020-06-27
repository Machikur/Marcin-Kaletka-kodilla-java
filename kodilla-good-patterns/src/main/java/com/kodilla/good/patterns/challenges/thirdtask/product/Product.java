package com.kodilla.good.patterns.challenges.thirdtask.product;

import java.util.Objects;

public class Product {
    private String name;
    private Quality quality;

    public Product(String name, Quality quality) {
        this.name = name;
        this.quality = quality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                quality == product.quality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quality);
    }
}
