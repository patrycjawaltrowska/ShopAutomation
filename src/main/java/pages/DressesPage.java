package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DressesPage extends BasePage {

    public DressesPage(WebDriver driver) {
        super(driver);
    }

    private By firstProduct = By.xpath("//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]/img");
    private By addToCartProductDetailsButtom = By.xpath("//*[@id='add_to_cart']/button/span");
    private By continueShoppingButton = By.xpath("//*[@title='Continue shopping']");

    private void addProductToCartFromDetails() {
        actionsHelper.click(addToCartProductDetailsButtom);
    }

    public DressesPage goToFirstProductDetails() {
        actionsHelper.click(firstProduct);
        return this;
    }

    public DressesPage addOneProductToCartAndContinues() {
        addProductToCartFromDetails();
        actionsHelper.click(continueShoppingButton);
        return this;
    }

}
