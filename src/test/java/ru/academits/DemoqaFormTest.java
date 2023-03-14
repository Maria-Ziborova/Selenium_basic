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
    public void checkFormElementStudentName() throws InterruptedException {
        WebElement nameElement = WebDriver.findElement(By.xpath("//*[contains(@class, 'table-dark')]//tbody//tr//td[2]"));
        Assertions.assertTrue(nameElement.isDisplayed());

        Thread.sleep(3000);

        String nameElementText = nameElement.getText();
        Assertions.assertEquals("Student Name", nameElementText);
    }

    @Test
    public void checkStudentFirstName(){
        WebElement checkFirstName = WebDriver.findElement(By.xpath("(//*[@id='firstName']"));
        String lastName = checkFirstName.getText();
        Assertions.assertEquals("Maria", lastName);
    }
    @Test
    public void checkStudentLastName(){
        WebElement checkLastName = WebDriver.findElement(By.xpath("(//*[@id='lastName']"));
        String lastName = checkLastName.getText();
        Assertions.assertEquals("Ziborova", lastName);
    }

    @Test
    public void checkStudentGender() {
        WebElement checkboxesGender = WebDriver.findElement(By.xpath("(//*[@type='radio'])[2]"));
        String genderText = checkboxesGender.getText();
        Assertions.assertEquals("Female", genderText);
    }

    @Test
    public void checkMobileNumber() {
        WebElement mobileNumber = WebDriver.findElement(By.xpath("//*[@placeholder='Mobile Number']"));
        Assertions.assertTrue(mobileNumber.isDisplayed());
    }

    @Test
    public void checkSelectHobbies() {
        WebElement selectHobby = WebDriver.findElement(By.xpath("//*[@id='hobbiesWrapper']//div[2]//div[1]"));
        Assertions.assertTrue(selectHobby.isSelected());
    }
    @Test
    public void checkHobbies() {
        WebElement hobbiesForm = WebDriver.findElement(By.xpath("//*[@id='hobbiesWrapper']"));
        List<WebElement> list = hobbiesForm.findElement(By.xpath("//*[@type='checkbox']"));
        for (WebElement item: list) {
            Assertions.assertEquals("checkbox", item.getAttribute("type"));
        }
    }
//*[@id = 'hobbiesWrapper']
    //*[contains(@class, 'month-container')]
    //*[@id = 'hobbiesWrapper']//div[2]//div[1]
    //*[@placeholder = 'Current Address']
    //*[@id='state']
    //*[@id='city']

    @Test
    public void formSubmission() {
        WebElement submitButton = WebDriver.findElement(By.xpath("//*[@id='submit']")).click();
        WebElement formTitle = driver.findElement(By.xpath("//*[contains(text(), 'Thanks')]"));
        String formTitleText = formTitle.getText();
        Assertions.assertEquals("Thanks for submitting the form", formTitleText);
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
