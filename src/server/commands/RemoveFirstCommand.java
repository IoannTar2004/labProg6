package src.server.commands;

import src.manager.ObjectsManager;
import src.tools.OutputText;

import java.util.List;

/**
 * Removes the first object in collection.
 */
public class RemoveFirstCommand implements Command {
    /**
     * Removes the first object in collection.
     */
    @Override
    public List<String> execute(String mode, String[] command, Object... args) {
        ObjectsManager objectsManager = new ObjectsManager();
        if (objectsManager.length() > 0) {
            objectsManager.remove_first();
            return List.of(OutputText.result("RemovedFirst"));
        }
        else {return List.of(OutputText.result("Empty"));}
    }
}
