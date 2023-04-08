package src.server.commands;

import src.manager.ObjectsCollectionManager;
import src.manager.ObjectsManager;
import src.tools.OutputText;

import java.util.List;

/**
 * Prints the first object in collection if it is not empty.
 */
public class HeadCommand implements Command {

    /**
     * Prints the first object in collection if it is not empty.
     */
    @Override
    public List<String> execute(String mode, String[] command, Object... args) {
        ObjectsManager objectsManager = new ObjectsManager();
        ObjectsCollectionManager getters = new ObjectsCollectionManager();

        if (objectsManager.length() > 0) {
            return List.of(getters.getDragonByIndex(0).toString());
        } else {
            return List.of(OutputText.result("Empty"));
        }
    }
}
