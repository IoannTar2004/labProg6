package src.server.commands;

import src.manager.ObjectsCollectionManager;
import src.manager.ObjectsManager;
import src.server.modules.ServerSender;
import src.support.Processing;
import src.tools.OutputText;
import src.collections.*;
import src.tools.IdGenerator;

import java.util.Arrays;
import java.util.LinkedList;
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
        if (Objects.equals(mode, "xml")) {
            List<Dragon> list = new LinkedList<>((List<Dragon>) args[0]);
            for (Dragon dragon : list) {
                new ObjectsManager().add(dragon);
            }
            return new ServerSender("");
        } else if (Objects.equals(mode, "script")) {
            for (DragonFields fields: DragonFields.values()) {
                args[fields.ordinal()] = new Processing().dragonProcessing(fields, (String) args[fields.ordinal()]);
            }
            new ObjectsManager().add(args);
            return new ServerSender(List.of(OutputText.result("Added")));

        } else if (Objects.equals(mode, "collection")) {
            new ObjectsManager().add(args);
            return new ServerSender(List.of(OutputText.result("Added")));

        } else {
            return new ServerSender("addDragon");
        }
    }
}
