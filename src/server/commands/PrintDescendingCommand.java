package src.server.commands;

import src.collections.DragonFields;
import src.support.Sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Prints objects in descending order by its value of field.
 */
public class PrintDescendingCommand implements Command {
    private static String[] arguments;
    /**
     * Prints objects in descending order by its value of field.
     */
    @Override
    public List<String> execute(String mode, String[] command, Object... args) {
        if (Objects.equals(mode, "script")) {
            executeWithScript(command, (String) args[0]);
        } else if (Objects.equals(mode, "server")) {
            return new LinkedList<>(Sort.sort(DragonFields.getFieldByNumber(command[0]), arguments));
        }
        else {
            arguments = command;
            return List.of("","fieldSelection");
        }
        return null;
    }

    /**
     * Triggers when command is from script file. Object is not created if at least one of the argument is invalid.
     * @param arg number of field
     */
    public static void executeWithScript(String[] command, String arg) {
        DragonFields fieldNum;

        fieldNum = DragonFields.getFieldByNumber(arg);
        assert fieldNum != null;
        Sort.sort(fieldNum, command);
    }
}
