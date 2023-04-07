package src.server.commands;

import src.manager.ObjectsManager;
import src.tools.OutputText;

/**
 * Clears collection.
 */
public class ClearCommand implements Command {
    /**
     * Clears collection.
     */
    @Override
    public Object[] execute(String mode, String[] command, String... args) {
        ObjectsManager objectsManager = new ObjectsManager();

        objectsManager.clear();
        return new Object[]{OutputText.result("Cleared")};
    }
}
