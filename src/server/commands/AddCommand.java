package src.server.commands;

import src.manager.ObjectsManager;
import src.server.modules.ServerSender;
import src.support.Processing;
import src.tools.OutputText;
import src.collections.*;
import src.tools.IdGenerator;

import java.util.List;
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
    public ServerSender execute(String mode, String[] command, Object... args) {
        if (Objects.equals(mode, "script")) {
            addWithScript(args[0], args[1], args[2], args[3], args[4], args[5], args[6]);
            return null;
        } else if (Objects.equals(mode, "server")) {
            ObjectsManager manager = new ObjectsManager();
            manager.add((Dragon) args[0]);
            return new ServerSender(List.of(OutputText.result("Added")));
        } else {
            return new ServerSender("addDragon");
        }
    }

    /**
     * Triggers when command is from script file. Object is not created if at least one of the argument is invalid.
     * @param args elements of dragon which written in script
     */
    public static void addWithScript(Object... args) {
        ObjectsManager objectsManager = new ObjectsManager();
        Processing manager = new Processing();
        Dragon dragon = new Dragon();

        for (DragonFields fields: DragonFields.values()) {
            Object element = manager.dragonProcessing(fields, args[fields.ordinal()].toString());
            if (element != null) {
                dragon = manager.dragonInput(dragon, fields, element);
            } else {return;}
        }
        dragon.setId(IdGenerator.generate());
        objectsManager.add(dragon);
    }
}
