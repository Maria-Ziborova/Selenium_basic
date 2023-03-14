package ru.academits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class FormaTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp () {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://demoqa.com/automation-practice-form/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }



    @Test
    public void checkUrlDemoqaTest() {
        Assertions.assertEquals("https://demoqa.com/automation-practice-form/", driver.getCurrentUrl());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

   @Test
    public void checkTitleDemoqaTest() {
        Assertions.assertEquals("DEMOQA", driver.getTitle());
    }

    public void checkFormElementName() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement nameElement = driver.findElement(By.xpath("//*[@id='firstName']"));
        Assertions.assertTrue(nameElement.isDisplayed());

        Thread.sleep(3000);

        String nameElementText = nameElement.getText();
        Assertions.assertEquals("Student Registration Form", nameElementText);
    }

    @Test
    public void checkForm() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
        WebElement nameElement = driver.findElement(By.xpath("//*[@class='modal-title h4']"));
        Assertions.assertTrue(nameElement.isDisplayed());

        webDriver.findElement(By.xpath("//*[@id='submit']")).click();

        Thread.sleep(3000);

        String nameElementText = nameElement.getText();
        Assertions.assertEquals("Thanks for submitting the form", nameElementText);
    }

    WebElement input = webDriver.findElement(By.xpath("//td[contains(text(), 'Student Name')]"));
    String text = input.getText();

}
