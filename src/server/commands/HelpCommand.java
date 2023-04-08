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
    public Object[] execute(String mode, String[] command, Object... args) {
        return new Object[]{OutputText.result("AllCommands")};
    }
}
