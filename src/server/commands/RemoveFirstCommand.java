package src.server.commands;

import src.manager.ObjectsManager;
import src.tools.OutputText;

/**
 * Removes the first object in collection.
 */
public class RemoveFirstCommand implements Command {
    /**
     * Removes the first object in collection.
     */
    @Override
    public void execute(String mode, String[] command, String... args) {
        ObjectsManager objectsManager = new ObjectsManager();
        if (objectsManager.length() > 0) {
            objectsManager.remove_first();
            OutputText.result("RemovedFirst");
        }
        else {OutputText.result("Empty");}
    }
}
