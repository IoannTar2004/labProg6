package src.server.commands;

import src.tools.OutputText;

/**
 * Prints all commands.
 */
public class HelpCommand implements Command {
    /**
     * Prints all commands.
     */
    @Override
    public String execute(String mode, String[] command, String... args) {
        return OutputText.result("AllCommands");
    }
}
