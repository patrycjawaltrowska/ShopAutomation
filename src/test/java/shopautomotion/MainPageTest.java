package shopautomotion;

import configuration.GlobalVariables;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import pages.DressesPage;
import pages.MainPage;


public class MainPageTest extends BaseTest {  // MainPage dziedziczy po BaseTest, podczas odpalenia metod z MainPage najpierw odpali sie BaseTest

    @Test
    public void loginSuccessfulTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.login(GlobalVariables.login, GlobalVariables.password);
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        Assertions.assertEquals("My account - My Shop", pageTitle);
    }

    @Test
    public void loginFailedTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.login(GlobalVariables.login, GlobalVariables.incorrectPassword);
        By failedInfoBox = By.xpath("//*[@id='center_column']/div[1]/p");
        String failedInfoText = driver.findElement(failedInfoBox).getText();
        Assertions.assertEquals("There is 1 error", failedInfoText);

    }

    @Test
    public void testLogOut() {
        MainPage mainPage = new MainPage(driver);
        mainPage.login(GlobalVariables.login, GlobalVariables.password)
                .logOut();
        Assertions.assertTrue(mainPage.verifySingInButton());
    }

    @Test
    public void testEmptyCart() {
        MainPage mainPage = new MainPage(driver);
        mainPage.goToCart();
        String cartText = mainPage.returnCartText();
        Assertions.assertEquals("Your shopping cart is empty.", cartText);
    }

}

