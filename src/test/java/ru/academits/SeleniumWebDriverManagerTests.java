package ru.academits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumWebDriverManagerTests {
    @Test
    public void simpleTest() {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("http://ya.ru");

        driver.quit();
    }


}
