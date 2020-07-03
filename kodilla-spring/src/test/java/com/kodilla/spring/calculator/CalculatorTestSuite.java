package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {

    @Test
    public void testCalculations() {

        //given
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        double a = 5;
        double b = 10;

        //when
        double sum = calculator.add(a, b);
        double sub = calculator.sub(a, b);
        double mul = calculator.mul(a, b);
        double div = calculator.div(a, b);

        //then
        Assert.assertEquals(15, sum, 0.1);
        Assert.assertEquals(-5, sub, 0.1);
        Assert.assertEquals(50, mul, 0.1);
        Assert.assertEquals(0.5, div, 0.1);

    }

}
