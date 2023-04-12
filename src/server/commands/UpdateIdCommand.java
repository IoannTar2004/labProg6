package src.server.commands;

import src.manager.ObjectsCollectionManager;
import src.manager.ObjectsManager;
import src.server.modules.ServerSender;
import src.support.IdChecker;
import src.support.Processing;
import src.tools.OutputText;
import src.collections.*;

import java.util.Arrays;
import java.util.Date;
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
             id = Long.parseLong(command[1]);
            try {
                String output = IdChecker.check(command[1]);
                if (Objects.equals(output, "Existed")) {
                    return new ServerSender("updateDragon");
                }
                return new ServerSender(List.of(IdChecker.check(command[1])));
            } catch (ArrayIndexOutOfBoundsException e) {
                return new ServerSender(List.of(OutputText.error("NoIdArgument")));
            }
        }
    }

}
