package com.kodilla.testing.shape;

import java.util.Objects;

public class Square implements Shape {

    private final String name="square";
    private int a;

    public Square(int a) {
        this.a = a;
    }

    public String getShameName() {
        return name;
    }

    public double getField() {
        return a*a;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return a == square.a &&
                Objects.equals(name, square.name);
    }

    public int hashCode() {
        return Objects.hash(name, a);
    }
}
