package src.server.modules;

import src.server.commands.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ServerInvoker {
    /**
     * This method receives entered or read from script command and splits by spaces.
     * It works while command is not "exit".
     */
    public static ServerSender invoke(String mode, Command command, String input, Object... args) {
        String[] line = input.trim().split("\\s+");
        try {
            return command.execute(mode, line, args);
        } catch (NullPointerException e) {
            if (Objects.equals(mode, "user")) {
                return new ServerSender(List.of("Такой команды нет!"));
            }
        }
        return null;
    }
}
