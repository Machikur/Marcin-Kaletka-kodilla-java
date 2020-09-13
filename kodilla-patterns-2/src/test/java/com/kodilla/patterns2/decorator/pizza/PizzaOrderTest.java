package com.kodilla.patterns2.decorator.pizza;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class PizzaOrderTest {

    @Test
    public void basicPizzaDescriptionTest() {
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //when
        String description = pizzaOrder.getDescription();

        //then
        Assert.assertEquals("Pizza with tomato sauce and cheese", description);
    }

    @Test
    public void basicPizzaCostTest() {
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //when
        BigDecimal cost = pizzaOrder.getCost();

        //then
        Assert.assertEquals(new BigDecimal(15), cost);
    }

    @Test
    public void basicPizzaPlusHawaiiDescriptionTest() {
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HawaiiPizzaDecorator(pizzaOrder);

        //when
        String description = pizzaOrder.getDescription();

        //then
        Assert.assertEquals("Pizza with tomato sauce and cheese + ham and pineapple", description);
    }

    @Test
    public void basicPizzaPlusHawaiiCostTest() {
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HawaiiPizzaDecorator(pizzaOrder);

        //when
        BigDecimal cost = pizzaOrder.getCost();

        //then
        Assert.assertEquals(new BigDecimal(25), cost);
    }

    @Test
    public void allIngredientsDescriptionTest() {
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HawaiiPizzaDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new ExtraHotDecorator(pizzaOrder);
        pizzaOrder = new VegetarianPizzaDecorator(pizzaOrder);

        //when
        String description = pizzaOrder.getDescription();

        //then
        Assert.assertEquals("Pizza with tomato sauce and cheese + ham and pineapple + " +
                "extra cheese + extra hot peppers + mix of vegetables", description);
    }

    @Test
    public void allIngredientsCostTest() {
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new HawaiiPizzaDecorator(pizzaOrder);
        pizzaOrder = new ExtraCheeseDecorator(pizzaOrder);
        pizzaOrder = new ExtraHotDecorator(pizzaOrder);
        pizzaOrder = new VegetarianPizzaDecorator(pizzaOrder);

        //when
        BigDecimal cost = pizzaOrder.getCost();

        //then
        Assert.assertEquals(new BigDecimal(41), cost);
    }
}