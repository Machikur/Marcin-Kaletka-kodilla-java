package com.kodilla.spring.calculator;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
    private final Display display;

    public Calculator(final Display display) {
        this.display = display;
    }

    public double add(double a, double b) {
        double result = a + b;
        display.displayValue(result);
        return result;
    }

    public double sub(double a, double b) {
        double result = a - b;
        display.displayValue(result);
        return result;
    }

    public double mul(double a, double b) {
        double result = a * b;
        display.displayValue(result);
        return result;
    }

    public double div(double a, double b) {
        if (b != 0) {
            double result = a / b;
            display.displayValue(result);
            return result;
        } else return 0;
    }
}
