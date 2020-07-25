package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;

@SpringBootTest
@RunWith(SpringRunner.class)
public class InvoiceDaoTestSuite {
    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //given
        Product productOne = new Product("Szynka");
        Product productTwo = new Product("Kiełba");

        Item itemOne = new Item(productOne, BigDecimal.TEN, 10);
        Item itemTwo = new Item(productTwo, BigDecimal.ONE, 12);

        Invoice invoice = new Invoice("23123", new ArrayList<>());
        invoice.getItems().add(itemOne);
        invoice.getItems().add(itemTwo);

        itemOne.setInvoice(invoice);
        itemTwo.setInvoice(invoice);

        //when
        invoiceDao.save(invoice);
        int invoiceID = invoice.getId();

        //then
        Assert.assertTrue(productOne.getId() != 0);
        Assert.assertTrue(itemOne.getId() != 0);
        Assert.assertTrue(invoice.getId() != 0);

        //cleanUp
        invoiceDao.deleteById(invoiceID);
    }
}
