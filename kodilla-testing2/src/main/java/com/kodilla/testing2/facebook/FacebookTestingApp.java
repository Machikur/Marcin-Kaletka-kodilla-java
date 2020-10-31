package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookTestingApp {

    public static final String FB_PAGE = "https://pl-pl.facebook.com/r.php";
    public static final String FIRSTNAME_FIELD = "//input[@id=\"u_0_n\"]";
    public static final String SURNAME_FIELD = "//input[@id=\"u_0_p\"]";
    public static final String MOBILE_NUMBER_FIELD = "//input[@id=\"u_0_s\"]";
    public static final String PASSWORD_FIELD = "//input[contains(@id,\"password\")]";
    public static final String DAY_OF_BIRTH_FIELD = "//select[@id=\"day\"]";
    public static final String MONTH_OF_BIRTH = "//select[@id=\"month\"]";
    public static final String YEAR_OF_BIRTH = "//select[@id=\"year\"]";
    public static final String GENDER = "//input[@id=\"u_0_5\"]";

    public static void main(String[] args) {
        WebDriver webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);

        ElementMethods elementMethods = new ElementMethods(webDriver);

        webDriver.get(FB_PAGE);

        WebElement acceptButton = webDriver.findElement(By.id("u_0_1e"));
        acceptButton.click();

        elementMethods.fillField(FIRSTNAME_FIELD, "moje imie");
        elementMethods.fillField(SURNAME_FIELD, "moje nazwisko");
        elementMethods.fillField(MOBILE_NUMBER_FIELD, "123124124213");
        elementMethods.fillField(PASSWORD_FIELD, "moje haslo");

        elementMethods.selectOption(DAY_OF_BIRTH_FIELD, 2);
        elementMethods.selectOption(MONTH_OF_BIRTH, 2);
        elementMethods.selectOption(YEAR_OF_BIRTH, 20);

        WebElement gender = webDriver.findElement(By.xpath(GENDER));
        gender.click();


    }

}
