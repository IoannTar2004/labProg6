package src.server.commands;

import src.server.manager.ObjectsManager;
import src.server.modules.ServerSender;
import src.support.OutputText;

import java.util.List;

/**
 * Removes the first object in collection.
 */
public class RemoveFirstCommand implements Command {
    /**
     * Removes the first object in collection.
     */
    @Override
    public ServerSender execute(String mode, String[] command, Object... args) {
        ObjectsManager objectsManager = new ObjectsManager();
        if (objectsManager.length() > 0) {
            objectsManager.remove_first();
            return new ServerSender(List.of(OutputText.result("RemovedFirst")));
        }
        else {
            return new ServerSender(List.of(OutputText.result("Empty")));
        }
    }
}
