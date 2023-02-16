package src.tools;

import java.io.*;

public class ScriptReader {
    public static void read(File file) {
        try {
            DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));

            String line = input.readLine();
            System.out.println(line);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
