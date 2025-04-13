package Com.SwagLabs.Utils;

import java.io.File;
import java.nio.file.Files;

public class FileUtils {
    private FileUtils() {
    }

    ;

    public static void deleteFile(File filePath) {
        if (filePath == null || !filePath.exists()) {
            LogsUtils.warn("File is null or not exist ", filePath.getPath());
        }
        File[] listFiles = filePath.listFiles();
        if (listFiles.length == 0) {
            LogsUtils.warn("list files is empty");
        }
        for (File file : listFiles) {
            if (file.isDirectory()) {
                deleteFile(file);
            } else {
                try {
                    Files.delete(file.toPath());
                } catch (Exception e) {
                    LogsUtils.warn("Failed to delete file", e.getMessage());
                }
            }
        }
    }

    public static File getlastFile(String Folder) {

        File file = new File(Folder);
        if (file == null || !file.exists()) {
            LogsUtils.warn("File Not Exist or null ", file.getPath());
        }
        File[] listFile = file.listFiles();
        if (listFile.length == 0) {
            LogsUtils.warn("listFile is empty");
        }
        File LastFil = listFile[0];
        for (File file1 : listFile) {
            if (file1.lastModified() > LastFil.lastModified()) {
                LastFil = file1;
            }

        }
        return LastFil;
    }
}


