package Com.SwagLabs.Utils;

import org.openqa.selenium.WebDriver;

public class BrowserAction {

    private BrowserAction(){} ;

    public static void CloseBrowser(WebDriver driver){
        driver.quit();
    }
    public static void NavigateToPage(WebDriver driver  , String url) {
        driver.navigate().to(url);
    }

    public static void BackToPreviousPage(WebDriver driver){
        driver.navigate().back();
    }

    public static void ReturnToNextPage(WebDriver driver){
        driver.navigate().forward();
    }

    public static void RefreshPage(WebDriver driver){
        driver.navigate().refresh();
    }

    public static String getPageTitle(WebDriver driver){
        return  driver.getTitle();
    }

    public static String GetPageURL(WebDriver driver){
        return driver.getCurrentUrl();
    }





}
