package ru.academits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;

import javax.xml.xpath.XPath;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DemoqaFormTest {
    private WebDriver driver;

    @BeforeEach
    public void setUpDemoQATest() {
        WebDriver driver = null;

        String browser = System.getProperty("browser");
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.get("https://demoqa.com/automation-practice-form/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void checkTitle() {
        WebElement formTitle = driver.findElement(By.xpath("//*[@class='modal-title h4']"));
        String formTitleText = formTitle.getText();
        Assertions.assertEquals("Thanks for submitting the form", formTitleText);
    }

    @Test
    public void checkStudentName() throws InterruptedException {
        WebElement studentName = WebDriver.findElement(By.xpath("//*[contains(@class,'table-dark')]//tbody//tr//td[2]"));
        Assertions.assertTrue(studentName.isDisplayed());

        Thread.sleep(3000);

        String studentNameText = studentName.getText();
        Assertions.assertEquals("Maria Ziborova", studentNameText);
    }

    @Test
    public void checkStudentEmail() throws InterruptedException {
        WebElement checkStudentEmail = WebDriver.findElement(By.xpath("//*[contains(@class,'table-dark')]//tbody//tr[2]//td[2]"));
        String studentEmailText = checkStudentEmail.getText();
        Assertions.assertEquals("m.s.ziborova@gmail.com", studentEmailText);
        Thread.sleep(5000);
    }

    @Test
    public void checkGender() {
        WebElement checkGender = WebDriver.findElement(By.xpath("//*[contains(@class,'table-dark')]//tbody//tr[3]//td[2]"));
        Assertions.assertTrue(checkGender.isDisplayed());
    }

    @Test
    public void checkMobileNumber() {
        WebElement checkMobile = WebDriver.findElement(By.xpath("//td[text()=\"Mobile\"]//..//td[2]"));
        Assertions.assertTrue(checkMobile.isDisplayed());
    }

    @Test
    public void checkDateOfBirth() {
        WebElement checkDateOfBirth = WebDriver.findElement(By.xpath("//td[normalize-space()='Date of Birth']//..//td[2]"));
        String dateOfBirthText = checkDateOfBirth.getText();
        Assertions.assertEquals("16 October, 1985", dateOfBirthText);
    }

    @Test
    public void checkSubjects() {
        WebElement checkSubjects = WebDriver.findElement(By.xpath("//td[normalize-space()='Subjects']//..//td[2]"));
        String subjectsText = checkSubjects.getText();
        Assertions.assertEquals("Computer Sience", subjectsText);
    }

    @Test
    public void checkHobbies() {
        WebElement checkHobbies = WebDriver.findElement(By.xpath("//td[text()='Hobbies']//..//td[2]"));
        String hobbiesText = checkHobbies.getText();
        Assertions.assertEquals("Sports", hobbiesText);
    }

    @Test
    public void checkImageUpload() {
        WebElement checkImageUpload = WebDriver.findElement(By.xpath("//td[text()='Picture']//..//td[2]"));
        Assertions.assertTrue(checkImageUpload.isDisplayed());
        File fileUploadImage = new File("Image.png");
        System.out.println(fileUploadImage.getAbsolutePath());
        Thread.sleep(5000);
    }

    @Test
    public void checkAddress() {
        WebElement checkAddress = WebDriver.findElement(By.xpath("//td[normalize-space()='Address']//..//td[2]"));
        String addressText = checkAddress.getText();
        Assertions.assertEquals("Sakko i Vancetti, 77", addressText);
    }

    @Test
    public void checkStateAndCity() {
        WebElement checkStateAndCity = WebDriver.findElement(By.xpath("//td[normalize-space()='State and City']//..//td[2]"));
        String stateAndCityText = checkStateAndCity.getText();
        Assertions.assertEquals("NCR Delhi", stateAndCityText);
    }

    @Test
    public void checkFormClose() {
        driver.findElement(By.xpath("//*[@id='closeLargeModal']")).click();
        WebElement formCloseTitle = driver.findElement(By.cssSelector(".main-header"));
        String formCloseTitleText = formCloseTitle.getText();
        Assertions.assertEquals("Practice Form", formCloseTitleText);
    }

    @AfterEach
    public void tearDownDemoQATest() {
        WebDriver driver = null;

        String browser = System.getProperty("browser");
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        System.out.println(("Current url = ") + driver.getCurrentUrl());
        Assertions.assertEquals("https://demoqa.com/automation-practice-form/", driver.getCurrentUrl());

        driver.quit();
    }

}
