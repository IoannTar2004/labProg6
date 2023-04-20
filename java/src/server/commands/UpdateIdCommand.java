package src.server.commands;

import src.server.manager.ObjectsCollectionManager;
import src.server.manager.ObjectsManager;
import src.server.modules.ServerSender;
import src.support.IdChecker;
import src.client.Processing;
import src.support.OutputText;
import src.collections.*;

import java.util.List;
import java.util.Objects;

/**
 * Changes {@link Dragon dragon's fields} by its ID.
 */
public class UpdateIdCommand implements Command {
    private static long id;
    /**
     * Changes {@link Dragon dragon's fields} by its ID.
     */
    @Override
    public ServerSender execute(String mode, String[] command, Object... args) {
         if (Objects.equals(mode, "script")) {
             id = Long.parseLong(command[1]);
             for (DragonFields fields: DragonFields.values()) {
                 args[fields.ordinal()] = new Processing().dragonProcessing(fields, (String) args[fields.ordinal()]);
             }
             new ObjectsManager().replace(id, args);
             return new ServerSender(List.of(OutputText.result("DataChanged")));

         } else if (Objects.equals(mode, "collection")) {
            new ObjectsManager().replace(id, args);
            return new ServerSender(List.of(OutputText.result("DataChanged")));

         } else {
            try {
                id = Long.parseLong(command[1]);
                String output = IdChecker.check(new ObjectsCollectionManager().getAll(),command[1]);
                if (Objects.equals(output, "Existed")) {
                    return new ServerSender(new Object[]{"updateDragon"});
                }
                return new ServerSender(List.of(output));
            } catch (ArrayIndexOutOfBoundsException e) {
                return new ServerSender(List.of(OutputText.error("NoIdArgument")));
            }
        }
    }

}
