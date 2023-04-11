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
            new ObjectsManager().add(args);
            return new ServerSender(List.of(OutputText.result("Added")));
        } else {
            return new ServerSender("addDragon");
        }
    }

}
