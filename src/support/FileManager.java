package src.support;

import java.io.File;
import java.io.FileReader;

/**
 * class for working with files
 */
public class FileManager {
    private static File file;

    public static File getFile() {
        return file;
    }

    public static void setFile(File file) {
        FileManager.file = file;
    }

    /**
     * Methods checks whether the file is empty or not.
     * @param file existed file
     * @return true or false
     */
    public static boolean isNotEmpty(File file) {
        try {
            FileReader reader = new FileReader(file);
            if(reader.read() == -1) {return false;}
        } catch (Exception ignored) {}
        return true;
    }
}
