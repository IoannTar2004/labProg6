package src.commands;

import src.tools.OutputText;

/**
 * Prints all commands.
 */
public class HelpCommand implements Command {
    /**
     * Prints all commands.
     */
    @Override
    public void execute(String mode, String[] line, String[] args) {
        OutputText.result("AllCommands");
    }
}
