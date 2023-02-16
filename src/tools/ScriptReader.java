package src.tools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScriptReader {
    public static List<String> read(File file) {
        List<String> commands = new ArrayList<>();
        try {
            DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
            Scanner scanner = new Scanner(file);

            do {
                String command = input.readLine();
                if (command != null) {commands.add(command);}
            } while(input.readLine() != null);

            input.close();
            return commands;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
