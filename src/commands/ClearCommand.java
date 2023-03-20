package src.commands;

import src.collections.CollectionManager;
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
        CollectionManager.clear();
        OutputText.result("Cleared");
    }
}
