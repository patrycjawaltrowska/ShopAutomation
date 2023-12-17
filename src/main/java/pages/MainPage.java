package pages;

import configuration.GlobalVariables;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By signInButton = By.xpath("//*[@class='login']");
    private By emailTextBox = By.xpath("//*[@id='email']");
    private By passwordTextBox = By.xpath("//*[@id='passwd']");
    private By signInConfirmButton = By.xpath("//*[@id='SubmitLogin']/span");
    private By logOutButton = By.xpath("//*[@title='Log me out']");
    private By cartButton = By.xpath("//*[@title='View my shopping cart']");
    private By cartEmptyPopUp = By.xpath("//*[@id='center_column']/p");
    private By menuDressesTab = By.xpath("//*[@id='block_top_menu']/ul/li[2]/a");
    private By cartAmountSummaryTextBox = By.xpath("//*[@id='summary_products_quantity']");



    public MainPage login(String login, String password) {
        actionsHelper.click(signInButton);
        actionsHelper.sendKeys(emailTextBox, login);
        actionsHelper.sendKeys(passwordTextBox, password);
        actionsHelper.click(signInConfirmButton);
        return this;
    }

    public MainPage logOut() {
        actionsHelper.click(logOutButton);
        return this;
    }

    public boolean verifySingInButton() {
        return actionsHelper.isDisplayed(signInButton, 5);
    }

    public MainPage goToCart() {
        actionsHelper.click(cartButton);
        return this;
    }

    public String returnCartText() {
        return actionsHelper.getText(cartEmptyPopUp);
    }

    public String checkProductAmountInCart() {
        return actionsHelper.getText(cartAmountSummaryTextBox);
    }

    public DressesPage goToDressesPage() {
        actionsHelper.click(menuDressesTab);
        return new DressesPage(driver);
    }
}
