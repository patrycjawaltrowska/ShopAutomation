package pages;

import helpers.ActionsHelper;
import helpers.WaitsHelper;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected ActionsHelper actionsHelper;
    protected WaitsHelper waitsHelper;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitsHelper = new WaitsHelper(driver);
        this.actionsHelper = new ActionsHelper(driver);
    }

}
