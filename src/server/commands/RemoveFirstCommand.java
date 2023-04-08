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
    public Object[] execute(String mode, String[] command, Object... args) {
        ObjectsManager objectsManager = new ObjectsManager();
        if (objectsManager.length() > 0) {
            objectsManager.remove_first();
            return new Object[]{OutputText.result("RemovedFirst")};
        }
        else {return new Object[]{OutputText.result("Empty")};}
    }
}
