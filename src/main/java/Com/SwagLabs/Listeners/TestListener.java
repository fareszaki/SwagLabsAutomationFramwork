package Com.SwagLabs.Listeners;

import Com.SwagLabs.Utils.*;
import org.testng.IExecutionListener;
import org.testng.IInvokedMethodListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;



public class TestListener implements IExecutionListener , IInvokedMethodListener, ITestListener {
     File AllureFile = new File("test-outputs/AllureResults");
        File LogsFile = new File("test-outputs/Logs");
        File ScreenShotFile = new File("test-outputs/ScreenFile");
     @Override
    public void onExecutionStart() {
        LogsUtils.info("Test Execution Start ");
        JsonUtils jsonUtils = new JsonUtils("Login_Data");
        LogsUtils.info("Loading properties file");
        propertiesUtils.LoadProperties() ;
        LogsUtils.info("File Loaded Correctly ");
        FileUtils.deleteFile(AllureFile);
        LogsUtils.info("Deleted Allure File");
        FileUtils.deleteFile(LogsFile);
        LogsUtils.info("Deleted Logs File");
       FileUtils.deleteFile(ScreenShotFile);
        LogsUtils.info("Deleted ScreenShot File");

    }
    public void afterInvocation(org.testng.IInvokedMethod method, org.testng.ITestResult testResult) {
        if (method.isTestMethod()) {
            switch (testResult.getStatus()) {
                case ITestResult.SUCCESS:
                    File existingFile = new File("test-output/ScreenFile/" + testResult.getName() + ".png");
                    if (existingFile.exists()) {
                        existingFile.delete();
                    }
                        ScreenShotUtils.TakeScreenShot("PASSED "+testResult.getName());
                    break;
                case ITestResult.FAILURE:
                     existingFile = new File("test-output/ScreenFile/" + testResult.getName() + ".png");
                    if (existingFile.exists()) {
                        existingFile.delete();
                    }
                    ScreenShotUtils.TakeScreenShot("FAILED "+testResult.getName());
                    break;
                case ITestResult.SKIP:
                      existingFile = new File("test-output/ScreenFile/" + testResult.getName() + ".png");
                     if (existingFile.exists()) {
                        existingFile.delete();
                    }
                    ScreenShotUtils.TakeScreenShot("SKIPPED "+testResult.getName());
                    break;
            }
            AllureUtils.attachLogs();
        }
    }

    public void onTestSuccess(org.testng.ITestResult rest) {
        LogsUtils.info("Test " + rest.getName() + " Successfully Passed");
        ScreenShotUtils.TakeScreenShot(rest.getMethod().getMethodName());


    }

    public void onTestFailure(org.testng.ITestResult result) {

        LogsUtils.info("Test "+result.getName()+ "Failed");
        ScreenShotUtils.TakeScreenShot(result.getMethod().getMethodName());


    }

    public void onTestSkipped(org.testng.ITestResult result) {
        LogsUtils.info("Test "+result.getMethod().getMethodName() + "Skipped");
        ScreenShotUtils.TakeScreenShot(result.getMethod().getMethodName());



    }

        @Override
   public void onExecutionFinish(){
        LogsUtils.info("Test Execution Finish ");
   }

}
