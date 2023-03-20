package src.commands;

import src.collections.DragonFields;
import src.support.InputManager;
import src.support.Sort;
import src.tools.OutputText;
import java.util.Objects;

/**
 * Prints objects in descending order by its value of field.
 */
public class PrintDescendingCommand implements Command {
    /**
     * Prints objects in descending order by its value of field.
     */
    @Override
    public void execute(String mode, String[] command, String... args) {
        if (Objects.equals(mode, "script")) {
            executeWithScript(command, args[0]);
        } else {printDescending(command);}
    }

    /**
     * Triggers when user enters this command to terminal
     */
    public static void printDescending(String[] command) {
        DragonFields fieldNum;
        InputManager manager = new InputManager();

        OutputText.input("DescendingInput");
        do {
            String input = manager.scanner();
            fieldNum = DragonFields.getFieldByNumber(input);
            if (fieldNum != null) {Sort.sort(fieldNum, command);}
        } while (fieldNum == null);
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
