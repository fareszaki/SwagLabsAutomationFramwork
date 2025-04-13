package Com.SwagLabs.Pages;

import Com.SwagLabs.Driver.DriverManager;
import Com.SwagLabs.Utils.BrowserAction;
import Com.SwagLabs.Utils.ElementActions;
import Com.SwagLabs.Utils.ValidationUtils;
import Com.SwagLabs.Utils.propertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver ;
    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private final By locateUserName = By.id("user-name");
    private final By locatePassword = By.id("password");
    private final By locateLoginButton = By.id("login-button");
    private final By locateErrorMessageforRequireduserName = By.cssSelector("#login_button_container > div > form > h3");
    private final By locateErrorMessageforRequiredPassword = By.cssSelector("#login_button_container > div > form > h3");
    private final By locateErrorforinvaliduserNameOrPassword = By.cssSelector("#login_button_container > div > form > h3");
     @Step("Navigate to the site:{PropertiesUtils.getProperty(\"url\")}")
    // Methods - Waits For Elements To be enable - Scroll to elements - FindElement - Action
    public void NavigateToSite() {
        BrowserAction.NavigateToPage(driver, propertiesUtils.getProperty("url"));
    }
    // Enter Email Account
     @Step("Enter the user name: {UserName}")
    public LoginPage EnterUserName(String UserName) {
        ElementActions.EnterDataOnField(driver, this.locateUserName, UserName);
        return this;
    }
    @Step("Enter the password: {Password}")

    public LoginPage EnterPassword(String Password) {
        ElementActions.EnterDataOnField(driver, this.locatePassword, Password);
        return this;
    }
   @Step("Click on the login button")
    public LoginPage ClickOnLoginButton() {
        ElementActions.ClickOnElement(driver, this.locateLoginButton);
        return this;
    }
   @Step("Assert User Successfully to Home Page")
    //Validations
    public HomePage AssertLoginSuccessfully() {
        ValidationUtils.AssertLoginSuccessfully();
        return new HomePage(driver) ;
    }
   @Step("Assert Error Message for Invalid Credentials")
    public void AssertDisplayeErrorForInvalidCredentials() {
        ValidationUtils.AssertLoginWithInvalidCredentials(driver, this.locateErrorforinvaliduserNameOrPassword);
    }
    @Step("Assert Error Message for Required User Name")
    public void AssertUserNameIsRequired() {
        ValidationUtils.AssertUserNameRequired(driver, this.locateErrorMessageforRequireduserName);
    }
    @Step("Assert Error Message for Required Password")
    public void AssertPasswordIsRequired() {
        ValidationUtils.AssertUserNameRequired(driver, this.locateErrorMessageforRequiredPassword);
    }


}
