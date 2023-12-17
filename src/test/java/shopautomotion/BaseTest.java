package shopautomotion;

import configuration.GlobalVariables;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    protected WebDriver driver;

    @Before
    public void setup() {

        System.setProperty("webdriver.chrome.bin", "C:/Users/Pyzunia/Desktop/chrome/chrome-win64/chrome.exe");
        System.setProperty("webdriver.chrome.driver", "C:/Users/Pyzunia/Desktop/chrome/chromedriver-win64/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(chromeOptions);
        driver.get(GlobalVariables.url);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }
}
