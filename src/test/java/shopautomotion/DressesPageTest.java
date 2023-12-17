package shopautomotion;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import pages.DressesPage;
import pages.MainPage;

public class DressesPageTest extends BaseTest{

    @Test
    public void testAddOneProductInCart() {
        MainPage mainPage = new MainPage(driver);
        DressesPage dressesPage = mainPage.goToDressesPage();
        dressesPage.goToFirstProductDetails()
                .addOneProductToCartAndContinues();
        mainPage.goToCart();
        String productAmount = mainPage.checkProductAmountInCart();
        Assertions.assertEquals("1 product", productAmount);

    }
}
