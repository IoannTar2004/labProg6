package src.server.commands;

import src.manager.ObjectsManager;
import src.support.IdChecker;
import src.support.InputManager;
import src.tools.OutputText;
import src.collections.*;

import java.util.Objects;
import java.util.Scanner;

/**
 * Changes {@link Dragon dragon's fields} by its ID.
 */
public class UpdateIdCommand implements Command {
    /**
     * Changes {@link Dragon dragon's fields} by its ID.
     */
    @Override
    public Object[] execute(String mode, String[] command, Object... args) {
        if (Objects.equals(mode, "script")) {
            updateWithScript(command, args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
        } else if (Objects.equals(mode, "server")) {
            ObjectsManager manager = new ObjectsManager();
            manager.replace(Long.valueOf(command[1]), (Dragon) args[0]);
            return new Object[]{OutputText.result("DataChanged")};
        }
        else {
            Dragon dragon = IdChecker.parse(command);
            if (dragon == null) {
                try {
                    return new Object[]{IdChecker.check(command[1])};
                } catch (ArrayIndexOutOfBoundsException e) {
                    return new Object[]{OutputText.error("NoIdArgument")};
                }
            } //TODO text
            return new Object[]{"","updateDragon"};
        }
        return null;
    }
    /**
     * Triggers when user enters this command to terminal
     */
    public static void update(String[] command) {
        Dragon dragon = IdChecker.parse(command);
        if (dragon == null) {return;}

        Scanner scanner = new Scanner(System.in);
        InputManager manager = new InputManager();
        nextField:
        for (DragonFields fields: DragonFields.values()) {
            Object element;
            OutputText.input(fields.getField() + "NewInput");
            do {
                String input = scanner.nextLine().trim();
                if (input.length() == 0) {continue nextField;}

                element = manager.dragonProcessing(fields, input);
            } while (element == null);
            dragon = manager.dragonInput(dragon, fields, element);
        }
        OutputText.result("DataChanged");
    }

    /**
     * Triggers when command is from script file. Object is not created if at least one of the argument is invalid.
     * @param args elements of dragon which written in script
     */
    public static void updateWithScript(String[] command, Object... args) {
        InputManager manager = new InputManager();

        Dragon dragon = IdChecker.parse(command);
        if (dragon == null) {return;}

        for (DragonFields fields : DragonFields.values()) {
            String arg = (String) args[fields.ordinal()];
            if (arg.length() == 0) {continue;}

            Object element = manager.dragonProcessing(fields, arg);
            if (element != null) {
                dragon = manager.dragonInput(dragon, fields, element);
            } else {return;}
        }
    }

}
