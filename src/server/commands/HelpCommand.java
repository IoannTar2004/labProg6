package src.server.commands;

import src.tools.OutputText;

import java.util.List;

/**
 * Prints all commands.
 */
public class HelpCommand implements Command {
    /**
     * Prints all commands.
     */
    @Override
    public List<String> execute(String mode, String[] command, Object... args) {
        return List.of(OutputText.result("AllCommands"));
    }
}
