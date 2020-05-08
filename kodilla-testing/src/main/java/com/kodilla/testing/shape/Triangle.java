package com.kodilla.testing.shape;

import java.util.Objects;

public class Triangle implements Shape {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return a == triangle.a &&
                b == triangle.b &&
                h == triangle.h &&
                Objects.equals(name, triangle.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, a, b, h);
    }

    private final String name="triangle";
    private int a;
    private int b;
    private int h;

    public Triangle(int a, int b, int h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    public String getShameName() {
        return name;
    }

    public double getField() {
        return (a+b)*h/2;
    }
}
