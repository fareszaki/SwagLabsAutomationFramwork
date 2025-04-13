package Com.SwagLabs.Driver;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    public static final ThreadLocal<WebDriver> threadlocal = new ThreadLocal<>();
    @Step("setting the driver")
    public static void setDriver(WebDriver driver ){
        threadlocal.set(driver);
    }
     @Step("getting the driver")
    public static WebDriver getDriver(){
        return threadlocal.get();
    }
    @Step("initializing the driver {" + "browserName" + "}")
    public static WebDriver getDriverInstance(String browserName){
        WebDriver driver = BrowserFactory.getDriverName(browserName);
        setDriver(driver);
        return getDriver();
    }

}
