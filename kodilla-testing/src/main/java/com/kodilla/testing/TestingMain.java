package com.kodilla.testing;

import com.kodilla.testing.calkulator.Calkulator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        System.out.println("Moduł 6. Wprowadzenie to testowania oprogramowania");

        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        System.out.println("Test - pierwszy test jednostkowy:");

        Calkulator calkulator = new Calkulator();

        int a = 10;
        int b = 5;

        int result1 = calkulator.add(a, b);

        if (result1 == a + b) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
        result1 = calkulator.substract(a, b);
        if (result1 == a - b) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }
    }
}