package Com.SwagLabs.Utils;

import io.qameta.allure.Allure;
import io.qameta.allure.util.ParameterUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllureUtils {
    private AllureUtils(){} ;


    public static void attachLogs(){
        try
        {
            File file = FileUtils.getlastFile(LogsUtils.Logs_Path); ;
            if (file == null || !file.exists()) {
                LogsUtils.warn("No logs found");
                return;
            }
            Allure.addAttachment("Logs.log", Files.readString(Path.of(file.getPath())));
        }catch (Exception e){
            LogsUtils.warn("Failed to attach logs to allure", e.getMessage());
        }
    }

    public static void attachScreenToAllure(String ScreenName , File filePath ){
        try {
            Allure.addAttachment(ScreenName, Files.newInputStream(filePath.toPath()));
        } catch (Exception e) {
            LogsUtils.warn("Failed to attach screen shot to allure", e.getMessage());
        }

    }

}
