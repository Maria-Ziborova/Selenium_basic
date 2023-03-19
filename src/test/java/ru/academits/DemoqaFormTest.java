package ru.academits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.File;
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
    public void checkDemoqaFormTest() throws InterruptedException {

        WebElement formTitle = driver.findElement(By.cssSelector(".practice-form-wrapper h5"));
        String formTitleText = formTitle.getText();
        Assertions.assertEquals("Student Registration Form", formTitleText);

        driver.findElement(By.cssSelector("#firstName")).sendKeys("Maria");
        driver.findElement(By.cssSelector("#lastName")).sendKeys("Ziborova");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("m.s.ziborova@gmail.com");
        driver.findElement(By.cssSelector("#gender-radio-2")).click();
        driver.findElement(By.cssSelector("#userNumber")).sendKeys("9631234567");

        driver.findElement(By.cssSelector("#dateOfBirthInput")).click();
        WebElement calendar = driver.findElement(By.xpath("//*[contains(@class,'month-container')]"));
        calendar.findElement(By.xpath("//*[@value='9']"));
        calendar.findElement(By.xpath("//*[@value='1985']"));
        calendar.findElement(By.xpath("//*[contains(@class,'day--016')]"));

        driver.findElement(By.xpath("(//*[contains(@class, 'subjects-auto-complete')])[1]")).sendKeys("Computer Sience");

        driver.findElement(By.cssSelector("#hobbies-checkbox-1")).click();

        driver.findElement(By.cssSelector("#uploadPicture")).click();
        File fileUploadImage = new File("Image.png");
        System.out.println(fileUploadImage.getAbsolutePath());

        driver.findElement(By.xpath("//*[@placeholder='Current Address']")).sendKeys("Sakko i Vancetti, 77");

        driver.findElement(By.xpath("(//*[@aria-hidden='true'])[1]")).sendKeys(Keys.RETURN);

        driver.findElement(By.xpath("(//*[@aria-hidden='true'])[3]")).sendKeys(Keys.RETURN);

        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(5000);

        WebElement completedFormTitle = driver.findElement(By.xpath("//*[@class='modal-title h4']"));
        String completedFormTitleText = completedFormTitle.getText();
        Assertions.assertEquals("Thanks for submitting the form", completedFormTitleText);

        WebElement checkStudentName = driver.findElement(By.xpath("//*[contains(@class,'table-dark')]//tbody//tr//td[2]"));
        String studentNameText = checkStudentName.getText();
        Assertions.assertEquals("Maria Ziborova", studentNameText);

        WebElement checkStudentEmail = driver.findElement(By.xpath("//*[contains(@class,'table-dark')]//tbody//tr[2]//td[2]"));
        String studentEmailText = checkStudentEmail.getText();
        Assertions.assertEquals("m.s.ziborova@gmail.com", studentEmailText);

        WebElement checkGender = driver.findElement(By.xpath("//*[contains(@class,'table-dark')]//tbody//tr[3]//td[2]"));
        Assertions.assertTrue(checkGender.isDisplayed());

        WebElement checkMobile = driver.findElement(By.xpath("//td[text()='Mobile']//..//td[2]"));
        Assertions.assertTrue(checkMobile.isDisplayed());

        WebElement checkDateOfBirth = driver.findElement(By.xpath("//td[normalize-space()='Date of Birth']//..//td[2]"));
        String dateOfBirthText = checkDateOfBirth.getText();
        Assertions.assertEquals("16 October, 1985", dateOfBirthText);

        WebElement checkSubjects = driver.findElement(By.xpath("//td[normalize-space()='Subjects']//..//td[2]"));
        String subjectsText = checkSubjects.getText();
        Assertions.assertEquals("Computer Sience", subjectsText);

        WebElement checkHobbies = driver.findElement(By.xpath("//td[text()='Hobbies']//..//td[2]"));
        String hobbiesText = checkHobbies.getText();
        Assertions.assertEquals("Sports", hobbiesText);

        WebElement checkImageUpload = driver.findElement(By.xpath("//td[text()='Picture']//..//td[2]"));
        Assertions.assertTrue(checkImageUpload.isDisplayed());

        WebElement checkAddress = driver.findElement(By.xpath("//td[normalize-space()='Address']//..//td[2]"));
        String addressText = checkAddress.getText();
        Assertions.assertEquals("Sakko i Vancetti, 77", addressText);

        WebElement checkStateAndCity = driver.findElement(By.xpath("//td[normalize-space()='State and City']//..//td[2]"));
        String stateAndCityText = checkStateAndCity.getText();
        Assertions.assertEquals("NCR Delhi", stateAndCityText);

        driver.findElement(By.xpath("//*[@id='closeLargeModal']")).click();
        Thread.sleep(5000);
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
