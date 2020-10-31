package com.kodilla.testing2.ebay;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EBayTestingApp {

    public static final String EBAY_PAGE="https://www.ebay.co.uk/";
    public static final String SERACH_FIELD="gh-ac";

    public static void main(String[] args) {
        WebDriver webDriver= WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get(EBAY_PAGE);

        WebElement element=webDriver.findElement(By.id(SERACH_FIELD));
        element.sendKeys("Laptop");
        element.submit();
    }
}
