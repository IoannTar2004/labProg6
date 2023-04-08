package src.server.commands;

import src.manager.ObjectsManager;
import src.support.IdChecker;
import src.support.InputManager;
import src.tools.OutputText;
import src.collections.*;

import java.util.List;
import java.util.Objects;

/**
 * Changes {@link Dragon dragon's fields} by its ID.
 */
public class UpdateIdCommand implements Command {
    /**
     * Changes {@link Dragon dragon's fields} by its ID.
     */
    @Override
    public List<String> execute(String mode, String[] command, Object... args) {
        if (Objects.equals(mode, "script")) {
            updateWithScript(command, args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
        } else if (Objects.equals(mode, "server")) {
            ObjectsManager manager = new ObjectsManager();
            manager.replace(Long.valueOf(command[1]), (Dragon) args[0]);
            return List.of(OutputText.result("DataChanged"));
        }
        else {
            Dragon dragon = IdChecker.parse(command);
            if (dragon == null) {
                try {
                    return List.of(IdChecker.check(command[1]));
                } catch (ArrayIndexOutOfBoundsException e) {
                    return List.of(OutputText.error("NoIdArgument"));
                }
            } //TODO text
            return List.of("","updateDragon");
        }
        return null;
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
