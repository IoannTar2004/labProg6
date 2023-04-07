package src.server.commands;

/**
 * interfaces for classes which are responsible to command
 */
public interface Command {
    /**
     *
     * @param mode - have two modes: user and script. "User" is switched on when you write down the command to terminal, "script" -
     *             when commands are executed from script files.
     * @param command - entered or read command (with arguments if they are required)
     * @param args - arguments are supplied to execute() only if the mode is "script" and command requires extra inputs (for
     *             example, add, update, print_descending).
     */
    Object[] execute(String mode, String[] command, String... args);
}
