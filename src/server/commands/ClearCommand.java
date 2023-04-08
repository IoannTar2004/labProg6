package src.server.commands;

import src.manager.ObjectsManager;
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
    public List<String> execute(String mode, String[] command, Object... args) {
        ObjectsManager objectsManager = new ObjectsManager();

        objectsManager.clear();
        return List.of(OutputText.result("Cleared"));
    }
}
