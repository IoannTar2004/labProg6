package src.tools;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScriptReader {
    public static List<String> read(File file) {
        List<String> commands = new ArrayList<>();
        String command;
        DataInputStream input;

        try {
            input = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        } catch (Exception e) {
            System.out.println("Файл не найден! Проверьте путь до файла.");
            return null;
        }
        try {
            do {
                command = input.readLine();
                if (command != null) {
                    commands.add(command);
                }
            } while (command != null);

            input.close();
        }
        catch (IOException e) {
            System.out.println("Возникли проблемы с input/output");
        }
            for(int i = 0; i < 8; i++) {
                commands.add("");
            }
            return commands;
    }
}
