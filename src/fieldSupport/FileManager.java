package src.fieldSupport;

import java.io.File;

public class FileManager {
    private static File file;

    public static File getFile() {
        return file;
    }

    public static void setFile(File file) {
        FileManager.file = file;
    }
}
