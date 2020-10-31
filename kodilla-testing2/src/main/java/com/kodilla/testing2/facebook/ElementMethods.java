package com.kodilla.testing2.facebook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementMethods {
    private WebDriver webDriver;

    public ElementMethods(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillField(String XPath,String text){
        WebElement element=webDriver.findElement(By.xpath(XPath));
        element.sendKeys(text);
    }

    public void selectOption(String XPath,int optionNumber){
        WebElement element=webDriver.findElement(By.xpath(XPath));
        Select select=new Select(element);
        select.selectByIndex(optionNumber);
    }
}
