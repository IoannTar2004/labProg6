package src.commands;

import src.collectionManager.CollectionManager;
import src.collectionManager.ObjectsManager;
import src.tools.OutputText;

/**
 * Clears collection.
 */
public class ClearCommand implements Command {
    /**
     * Clears collection.
     */
    @Override
    public void execute(String mode, String[] command, String... args) {
        ObjectsManager objectsManager = new ObjectsManager();

        objectsManager.clear();
        OutputText.result("Cleared");
    }
}
