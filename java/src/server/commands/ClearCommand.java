package src.server.commands;

import src.manager.ObjectsManager;
import src.server.modules.ServerSender;
import src.tools.OutputText;

import java.util.List;

/**
 * Clears collection.
 */
public class ClearCommand implements Command {
    /**
     * Clears collection.
     */
    @Override
    public ServerSender execute(String mode, String[] command, Object... args) {
        ObjectsManager objectsManager = new ObjectsManager();

        objectsManager.clear();
        return new ServerSender(List.of(OutputText.result("Cleared")));
    }
}
