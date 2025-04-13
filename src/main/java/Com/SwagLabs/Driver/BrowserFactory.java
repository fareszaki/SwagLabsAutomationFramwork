package Com.SwagLabs.Driver;

import Com.SwagLabs.Utils.Options;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    private BrowserFactory() {}

    @Step("getting the driver instance")
    public static WebDriver getDriverName(String BrowserName) {
        if (BrowserName == null) {
            throw new IllegalArgumentException("BrowserName cannot be null");
        }
        switch (BrowserName.toLowerCase()) {
            case "chrome":
                return new ChromeDriver(Options.getChromeOptions());
            case "firefox":
                return new FirefoxDriver(Options.getFirefoxOptions());
            default:
                return new EdgeDriver(Options.getEdgeOptions());
        }
    }
}