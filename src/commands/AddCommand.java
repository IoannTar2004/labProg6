package src.commands;

import src.manager.ObjectsManager;
import src.support.InputManager;
import src.tools.OutputText;
import src.collections.*;
import src.tools.IdGenerator;

import java.util.Objects;

/**
 * Add object to collection.
 */
public class AddCommand implements Command {

    /**
     * Add object to collection.
     *
     * @param mode
     * @param command
     * @param args
     */
    @Override
    public void execute(String mode, String[] command, String... args) {
        if (Objects.equals(mode, "script")) {
            addWithScript(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
        } else {add();}
    }

    /**
     * Triggers when user enters this command to terminal
     */
    public static void add() {
        InputManager manager = new InputManager();
        ObjectsManager objectsManager = new ObjectsManager();
        Dragon dragon = new Dragon();

        for (DragonFields fields: DragonFields.values()) {
            Object element;
            OutputText.input(fields.getField() + "Input");
            do {
                String input = manager.scanner();
                element = manager.dragonProcessing(fields, input);
            } while (element == null);
            dragon = manager.dragonInput(dragon, fields, element);
        }
        dragon.setId(IdGenerator.generate());
        objectsManager.add(dragon);
        OutputText.result("Added");
    }

    /**
     * Triggers when command is from script file. Object is not created if at least one of the argument is invalid.
     * @param args elements of dragon which written in script
     */
    public static void addWithScript(String... args) {
        ObjectsManager objectsManager = new ObjectsManager();
        InputManager manager = new InputManager();
        Dragon dragon = new Dragon();

        for (DragonFields fields: DragonFields.values()) {
            Object element = manager.dragonProcessing(fields, args[fields.ordinal()]);
            if (element != null) {
                dragon = manager.dragonInput(dragon, fields, element);
            } else {return;}
        }
        dragon.setId(IdGenerator.generate());
        objectsManager.add(dragon);
    }
}
