package Com.SwagLabs.Tests;

import Com.SwagLabs.Driver.DriverManager;
import Com.SwagLabs.Listeners.TestListener;
import Com.SwagLabs.Pages.*;
import Com.SwagLabs.Utils.BrowserAction;
import Com.SwagLabs.Utils.JsonUtils;
import Com.SwagLabs.Utils.propertiesUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class e2E {
    JsonUtils jsonUtils;
    WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void Set_Up() {
        driver = DriverManager.getDriverInstance(propertiesUtils.getProperty("browserType"));
        jsonUtils = new JsonUtils("Login_Data");
        new LoginPage(driver).NavigateToSite();

    }

    @Test
    public void LoginWithValidCredentials() {
        new LoginPage(driver).EnterUserName(JsonUtils.getJsonValue("valid_data.username"))
                .EnterPassword(JsonUtils.getJsonValue("valid_data.Password"))
                .ClickOnLoginButton().AssertLoginSuccessfully();

    }

    @Test(dependsOnMethods = "LoginWithValidCredentials")
    public void verifyAddingItemToCart() {
        new HomePage(driver).addProductToCart(JsonUtils.getJsonValue("products.item1.name"));
    }

    @Test(dependsOnMethods = "verifyAddingItemToCart")
    public void checkNumOfProductsAddedDisplayedCorrectly() {
        new HomePage(driver).assertProductsAddedCorrectlyToCart(JsonUtils.getJsonValue("numOfProduct"));
    }

    @Test(dependsOnMethods = "verifyAddingItemToCart")
    public void verifyProductDetailsAddedToCart() {
        new HomePage(driver).clickOnCartButton()
                .assertItemDetails(JsonUtils.getJsonValue("products.item1.name"),
                        JsonUtils.getJsonValue("products.item1.price"));
    }

    @Test(dependsOnMethods = "verifyProductDetailsAddedToCart")
    public void verifyCheckoutWithValidData() {
        new CartPage(driver).clickOnCheckOutButton().enterFirstName(JsonUtils.getJsonValue("checkoutData.firstName"))
                .enterLastName(JsonUtils.getJsonValue("checkoutData.lastName"))
                .enterZipCode(JsonUtils.getJsonValue("checkoutData.postalCode")).assertInformationEntered((JsonUtils.getJsonValue("checkoutData.firstName")),
                        (JsonUtils.getJsonValue("checkoutData.lastName")), JsonUtils.getJsonValue("checkoutData.postalCode")).
                clickOnContinueButton();
    }

    @Test(dependsOnMethods = "verifyCheckoutWithValidData")
    public void verifyReviewOrder() {
        new ReviewPage(driver).validateAllDataAreCorrectly(JsonUtils.getJsonValue("products.item1.name"),
                JsonUtils.getJsonValue("products.item1.allprice")).clickOnFinishButton();

    }

    @Test(dependsOnMethods = "verifyCheckoutWithValidData")
    public void assertOrderCompleteSuccessfully() {
        new CompletePage(driver).assertOrderCompleteCorrectly(JsonUtils.getJsonValue("confirmMessage"));
    }

    @AfterClass(alwaysRun = true)
    public void TearDown() {
        BrowserAction.CloseBrowser(driver);
    }

}
