package Com.SwagLabs.Utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Properties;

public class propertiesUtils {

    private propertiesUtils() {} ;
    private static final String propertiesPath = "src/main/resources/";

    public static Properties LoadProperties() {
        try {
            Properties properties = new Properties();
            Collection<File> ProprtiesFiles;
            ProprtiesFiles = FileUtils.listFiles(new File(propertiesPath), new String[]{"properties"}, true);
            for (File file : ProprtiesFiles) {
                try {
                    properties.load(new FileInputStream(file));
                } catch (Exception e) {
                    LogsUtils.warn("Failed to load properties file", e.getMessage());
                }
            }
            properties.putAll(System.getProperties());
            System.getProperties().putAll(properties);
            LogsUtils.info("Properties loaded successfully");
            return properties;
        } catch (Exception e) {
            LogsUtils.warn("Failed to load properties file", e.getMessage());
            return null;
        }
    }

    public static String getProperty(String key) {
        try {
            return System.getProperty(key);
        } catch (Exception e) {
            LogsUtils.warn("Failed to get property", e.getMessage());
            return " ";
        }
    }
}