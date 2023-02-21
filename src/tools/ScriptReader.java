package src.tools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScriptReader {
    public static List<String> read(File file) {
        List<String> commands = new ArrayList<>();
        String command;
        try {
            DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));

            do {
                command = input.readLine();
                if (command != null) {commands.add(command);}
            } while(command != null);
            input.close();

            for(int i = 0; i < 8; i++) {
                commands.add("");
            }
            return commands;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
