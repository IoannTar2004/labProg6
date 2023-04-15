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
    public static List<String> read(File file) throws FileNotFoundException {
        List<String> commands = new ArrayList<>();
        String command;
        BufferedReader buffer;
        buffer = new BufferedReader(new FileReader(file));

        try {
            do {
                command = buffer.readLine();
                commands.add(command);
            } while (command != null);

            buffer.close();
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
