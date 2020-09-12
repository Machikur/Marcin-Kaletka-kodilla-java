package com.kodilla.patterns2.decorator.taxiportal;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class TaxiOrderTest {

    @Test
    public void testBasicTaxiOrderGetCost() {
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        //when
        BigDecimal calculatedCost = taxiOrder.getCost();
        //then
        Assert.assertEquals(new BigDecimal(5), calculatedCost);
    }

    @Test
    public void testBasicTaxiOrderGetDescription(){
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        //when
        String description = taxiOrder.getDescription();
        //then
        Assert.assertEquals("Drive a course", description);
    }

    @Test
    public void testTaxiNetworkGetDescription(){
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder= new TaxiNetworkOrderDecorator(taxiOrder);

        //when
        String description = taxiOrder.getDescription();
        //then
        Assert.assertEquals("Drive a course by taxi Network", description);
    }

    @Test
    public void testTaxiNetworkGetCost(){
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder= new TaxiNetworkOrderDecorator(taxiOrder);
        //when
        BigDecimal calculatedCost = taxiOrder.getCost();
        //then
        Assert.assertEquals(new BigDecimal(40), calculatedCost);
    }
    @Test
    public void testMyTaxiWithChildSeatGetCost(){
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new MyTaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder= new ChildSeatDecorator(taxiOrder);
        //when
        BigDecimal calculatedCost = taxiOrder.getCost();
        //then
        Assert.assertEquals(new BigDecimal(37), calculatedCost);
    }

    @Test
    public void testMyTaxiWithChildSeatGetDecription(){
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new MyTaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder= new ChildSeatDecorator(taxiOrder);
        //when
        String description=taxiOrder.getDescription();
        //then
        Assert.assertEquals("Drive a course by MyTaxi Network + child seat",description);
    }

    @Test
    public void testMyTaxiWithTwoChildSeatGetDecription(){
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder = new MyTaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder= new ChildSeatDecorator(taxiOrder);
        taxiOrder= new ChildSeatDecorator(taxiOrder);
        //when
        String description=taxiOrder.getDescription();
        //then
        Assert.assertEquals("Drive a course by MyTaxi Network + child seat + child seat",description);
    }
    @Test
    public void testVipTaxiWithChildSeatExpressGetCost(){
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder= new TaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder=new VipDecorator(taxiOrder);
        taxiOrder=new ChildSeatDecorator(taxiOrder);
        //when
        BigDecimal calculatedCost = taxiOrder.getCost();
        //then
        Assert.assertEquals(new BigDecimal(52), calculatedCost);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetDescription(){
        //given
        TaxiOrder taxiOrder = new BasicTaxiOrder();
        taxiOrder= new TaxiNetworkOrderDecorator(taxiOrder);
        taxiOrder=new VipDecorator(taxiOrder);
        taxiOrder=new ChildSeatDecorator(taxiOrder);
        //when
        String description= taxiOrder.getDescription();
        //then
        Assert.assertEquals("Drive a course by Taxi Network variant VIP + child seat", description);
    }
}