package Com.SwagLabs.Utils;

import Com.SwagLabs.Driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;

public class ScreenShotUtils {
     private  ScreenShotUtils(){} ;
     public static final String ScreenPath = "test-outputs/ScreenFile/";

    public static void TakeScreenShot(String ScreenName) {
        try {
            // Ensure directory exists first
            File directory = new File(ScreenPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            // Then proceed with screenshot file creation
            File ScreenShotPath = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            File screenfile = new File(ScreenPath + ScreenName + ".png");
            FileUtils.copyFile(ScreenShotPath, screenfile);
            AllureUtils.attachScreenToAllure(ScreenName, screenfile);
            LogsUtils.info("ScreenShot taken successfully");
        } catch (Exception e) {
            LogsUtils.error("Failed to take screen shot", e.getMessage());
        }
    }
 }
