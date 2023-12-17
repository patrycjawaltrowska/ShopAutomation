package helpers;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsHelper {


    private WebDriver driver;
    private WaitsHelper waitsHelper;


    public ActionsHelper(WebDriver driver) {
        this.driver = driver;
        this.waitsHelper = new WaitsHelper(driver);
    }

    @SneakyThrows
    public void click(By bySelector) { //click elementu w pętli ze zdefiniowaniem Webelementu w każdym obrocie pętli

        int count = 0;
        Exception exceptionValue = null;
        WebElement element = null;

        while (count < 120) {
            try {
                waitsHelper.implicitWait(0);
                element = driver.findElement(bySelector);

                try {
                    new Actions(driver).moveToElement(element).perform();
                } catch (Exception e) {

                }
                element.click();
                Thread.sleep(1000);
                break;
            } catch (Exception e) {
                exceptionValue = e;
                count++;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
        if (count == 120) {//If all tries have failed then the following is executed.
            System.out.println("ERROR!!! Something went wrong and the action hasn't been completed successfully \n" + exceptionValue);
//            throw new Exception(exceptionValue);
        }
    }


    @SneakyThrows
    public void sendKeys(By bySelector, String text) { //usuwanie istniejącego tekstu z text boxa i wysłanie nowej wartości

        int count = 0;
        Exception exceptionValue = null;
        WebElement element = null;

        while (count < 120) {
            try {
                waitsHelper.implicitWait(0);
                element = driver.findElement(bySelector);

                new Actions(driver).moveToElement(element).perform();
                element.click();
                element.sendKeys(Keys.chord(Keys.CONTROL, "a"));//Selects everything. Better than clear() method.
                element.sendKeys(text);
                Thread.sleep(1000);
                break;
            } catch (Exception e) {
                exceptionValue = e;
                count++;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
        if (count == 120) {
            System.out.println("ERROR!!! Something went wrong and the action hasn't been completed successfully \n" + exceptionValue);
//            throw new Exception(exceptionValue);
        }
    }

    public boolean isDisplayed(By bySelector, int timeout) {
        try {
            waitsHelper.implicitWait(timeout);
            WebElement element = driver.findElement(bySelector);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;//If an exception occurs then it means that the element is not displayed.
        }
    }

    @SneakyThrows
    public String getText(By by) {

        String value = "Web Driver was unable to get text of the element.";
        int count = 0;
        WebElement element = null;
        while (count < 120) {
            try {
                waitsHelper.implicitWait(0);
                element = driver.findElement(by);
                new Actions(driver).moveToElement(element).perform();
                value = element.getText();
                if (value.length() > 0)
                    break;
                else {
                    count++;
                    Thread.sleep(500);
                }
            } catch (Exception e) {
                System.out.println("getText(By, String) catch executed!" + count);
                count++;
            }
        }
        if (count == 120) {
        }
        return value;
    }
}
