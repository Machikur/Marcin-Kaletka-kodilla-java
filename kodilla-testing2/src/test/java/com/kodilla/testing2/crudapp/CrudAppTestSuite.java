package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://machikur.github.io/";
    private WebDriver driver;
    private Random random;

    @Before
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
        random = new Random();
    }

    @After
    public void clanUpAfterTests() {
        driver.close();
    }

    @Test
    public void schouldCreateTrelloCard() throws InterruptedException {


        String taskName = createCrudAppTestTask();
        sendTaskToTrello(taskName);
        Assert.assertTrue(checkTaskExistsInTrello(taskName));
        Assert.assertTrue(deleteTaskFromKodillaApp(taskName));

    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]/fieldset[2]/textarea";
        final String XPATH_TASK_BUTTON = "//form[contains(@action, \"createTask\")]/fieldset[3]/button";

        String taskName = "Task number " + random.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement button = driver.findElement(By.xpath(XPATH_TASK_BUTTON));
        button.click();
        Thread.sleep(2000);
        return taskName;
    }

    private void sendTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(5000);
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        driverTrello.findElement(By.id("user")).sendKeys("machikur2@gmail.com");
        driverTrello.findElement(By.id("password")).sendKeys("TrelloHaslo");
        WebElement el = driverTrello.findElement(By.id("login"));
        el.submit();
        Thread.sleep(4000);

        driverTrello.findElement(By.id("password")).sendKeys("TrelloHaslo");
        driverTrello.findElement(By.id("login-submit")).click();

        Thread.sleep(4000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> aHref.findElements(By.xpath(".//div[@title=\"Kodilla Application\"]")).size() > 0)
                .forEach(WebElement::click);
        Thread.sleep(4000);
        result = driverTrello.findElements(By.xpath("//span")).stream()
                .anyMatch(theSpan -> theSpan.getText().equals(taskName));

        driverTrello.close();
        return result;


    }

    private boolean deleteTaskFromKodillaApp(String taskName) {

        driver.switchTo().alert().accept();

        while (!driver.findElement(By.xpath("//button[1]")).isDisplayed()) ;

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(text(),\"Delete\")]"));
                    buttonCreateCard.click();
                });

        return driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream().noneMatch(anyForm ->
                anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText().equals(taskName));

    }


}
