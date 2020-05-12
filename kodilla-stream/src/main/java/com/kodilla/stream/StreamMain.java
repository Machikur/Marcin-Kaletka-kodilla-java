package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

public class StreamMain {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(5, 10, (a, b) -> a + b);
        expressionExecutor.executeExpression(5, 10, (a, b) -> a - b);
        expressionExecutor.executeExpression(5, 10, (a, b) -> a * b);
        expressionExecutor.executeExpression(5, 10, (a, b) -> a / b);

        expressionExecutor.executeExpression(10, 20, FunctionalCalculator::addAToB);

        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Janusz", (a) -> System.out.println("---" + a.toUpperCase() + "---"));
        poemBeautifier.beautify("Janek", (a) -> System.out.println(a.toUpperCase()));
        poemBeautifier.beautify("Janusz", (a) -> System.out.println(a.toLowerCase()));

        poemBeautifier.beautify("Janusz", PoemBeautifier::getBeauty);
    }

}