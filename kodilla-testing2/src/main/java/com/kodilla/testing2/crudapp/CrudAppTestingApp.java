package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CrudAppTestingApp {
    public final static String XPATH_INPUT="/html/body/main/section/form/fieldset/input";
    public final static String XPATH_TEXT_AREA="/html/body/main/section/form/fieldset[2]/textarea";
    public final static String XPATH_WAIT_FOR ="//select[1]";
    public final static String XPATH_SELECT="//div[contains(@class, \"tasks-container\")]/form/div/fieldset/select[1]";


    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://machikur.github.io/");

        WebElement searchElement=driver.findElement(By.xpath(XPATH_INPUT));
        searchElement.sendKeys("New robotic task");

        WebElement testSearchField=driver.findElement(By.xpath(XPATH_TEXT_AREA));
        testSearchField.sendKeys("New robotic content");

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR)).isDisplayed());

        WebElement selectCombo = driver.findElement(By.xpath(XPATH_SELECT));
        Select selectBoard= new Select(selectCombo);
        selectBoard.selectByIndex(1);
    }
}
