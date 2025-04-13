package Com.SwagLabs.Tests;

import Com.SwagLabs.Driver.DriverManager;
import Com.SwagLabs.Listeners.TestListener;
import Com.SwagLabs.Pages.HomePage;
import Com.SwagLabs.Pages.LoginPage;
import Com.SwagLabs.Utils.BrowserAction;
import Com.SwagLabs.Utils.JsonUtils;
import Com.SwagLabs.Utils.propertiesUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class e2E  {
    JsonUtils jsonUtils ;
    WebDriver driver ;
    @BeforeClass
    public void Set_Up(){

        driver = DriverManager.getDriverInstance(propertiesUtils.getProperty("browserType"));
       jsonUtils = new JsonUtils("Login_Data");
        new LoginPage(driver).NavigateToSite();


    }

    @Test
    public void LoginWithValidCredentials() {
        new LoginPage(driver).EnterUserName(JsonUtils.getJsonValue("valid_data.username"))
                .EnterPassword(JsonUtils.getJsonValue("valid_data.Password")).ClickOnLoginButton().AssertLoginSuccessfully();

    }

    @Test(dependsOnMethods = {"LoginWithValidCredentials"})
    public void verifyAddingProductToCart() {
        new HomePage(driver).addProductToCart(jsonUtils.getJsonValue("products.item1.name"))
                .assertAddedProductCorrectly(jsonUtils.getJsonValue("products.item1.name") , jsonUtils.getJsonValue("buttonName"));
    }

    @Test(dependsOnMethods = "LoginWithValidCredentials")
    public void verifyAddingMultipleItemToCart(){

        new HomePage(driver).addProductToCart(JsonUtils.getJsonValue("products.item1.name")).addProductToCart(JsonUtils.getJsonValue("products.item2.name")).clickOnCartButton().deleteItemFromCart(JsonUtils.getJsonValue("products.item2.name"));
    }

     @Test(dependsOnMethods = "verifyAddingProductToCart")
    public void checkNumOfProductsAddedDisplayedCorrectly() {
        new HomePage(driver).assertProductsAddedCorrectlyToCart(jsonUtils.getJsonValue("numofproducts"));
    }


    @Test(dependsOnMethods ="checkNumOfProductsAddedDisplayedCorrectly" )
    public void navigateToCartPage(){
      //  new HomePage(driver).clickOnCartButton().assertNavigateToCartPage(propertiesUtils.getProperty("CartURL")); ;
    }



    @AfterClass
    public void TearDown(){
       //BrowserAction.CloseBrowser(driver);
    }

}
