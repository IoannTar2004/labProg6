package src.support;

import java.io.File;

/**
 * class for saving an initial file
 */
public class FileManager {
    private static File file;

    public static File getFile() {
        return file;
    }

    public static void setFile(File file) {
        FileManager.file = file;
    }
}
