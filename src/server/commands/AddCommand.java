package src.server.commands;

import src.manager.ObjectsCollectionManager;
import src.manager.ObjectsElements;
import src.manager.ObjectsManager;
import src.server.modules.ServerSender;
import src.support.Processing;
import src.tools.OutputText;
import src.collections.*;
import src.tools.IdGenerator;

import java.util.Arrays;
import java.util.Date;
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
            addWithScript(args);
        } else if (Objects.equals(mode, "collection")) {
            ObjectsManager manager = new ObjectsManager();
            Dragon dragon = new Dragon(IdGenerator.generate(), (String) args[0], (Coordinates) args[1],
                    (int) args[2], (Color) args[3], (DragonType) args[4], (DragonCharacter) args[5],
                    (DragonCave) args[6], new Date());
            manager.add(dragon);

            return new ServerSender(List.of(OutputText.result("Added")));
        } else {
            return new ServerSender("addDragon");
        }
        return null;
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
