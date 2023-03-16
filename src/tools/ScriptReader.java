package src.tools;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ScriptReader {
    /**
     * Reads entered script file with commands.
     * @param file script file
     * @return list of commands
     */
    public static List<String> read(File file) {
        List<String> commands = new ArrayList<>();
        String command;
        BufferedReader buffer;
        BufferedInputStream input;

        try {
            input = new BufferedInputStream(new FileInputStream(file));
            buffer = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        } catch (Exception e) {
            OutputText.error("FileNotFound");
            return null;
        }
        try {
            do {
                command = buffer.readLine();
                if (command != null) {
                    commands.add(command);
                }
            } while (command != null);

            buffer.close();
            input.close();
        }
        catch (IOException e) {
            System.out.println("Возникли проблемы с input/output");
        }
        for(int i = 0; i < 8; i++) {
            commands.add(null);
        }
        return commands;
    }
}
