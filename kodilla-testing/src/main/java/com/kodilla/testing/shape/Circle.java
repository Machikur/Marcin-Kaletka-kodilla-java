package com.kodilla.testing.shape;

import java.util.Objects;

public class Circle implements Shape {
    private final String name = "circle";
    private int r;

    public Circle(int r) {
        this.r = r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return r == circle.r &&
                Objects.equals(name, circle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, r);
    }

    public String getShameName() {
        return name;
    }

    public double getField() {
        return 3.14 * r * r;
    }
}
