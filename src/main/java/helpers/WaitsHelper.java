package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class WaitsHelper {

    private WebDriver driver;
    public WaitsHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void implicitWait(int time) {

        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

    }
}
