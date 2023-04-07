package src.server.modules;

import src.server.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ServerInvoker {
    /**
     * This method receives entered or read from script command and splits by spaces.
     * It works while command is not "exit".
     */
    public static String invoke(String mode, Command command, String input, String... args) {
        String[] line = input.trim().split("\\s+");
        try {
            command.execute(mode, line, args);
        } catch (NullPointerException e) {
            if (Objects.equals(mode, "user")) {
                System.out.println("Такой команды нет!\n");
            }
        }
    }
}
