package src.server.commands;

import src.manager.ObjectsCollectionManager;
import src.manager.ObjectsManager;
import src.tools.OutputText;

/**
 * Prints the first object in collection if it is not empty.
 */
public class HeadCommand implements Command {

    /**
     * Prints the first object in collection if it is not empty.
     */
    @Override
    public Object[] execute(String mode, String[] command, Object... args) {
        ObjectsManager objectsManager = new ObjectsManager();
        ObjectsCollectionManager getters = new ObjectsCollectionManager();

        if (objectsManager.length() > 0) {
            return new Object[]{getters.getDragonByIndex(0).toString()};
        } else {
            return new Object[]{OutputText.result("Empty")};
        }
    }
}
