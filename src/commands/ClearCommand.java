package src.commands;

import src.collectionClasses.CollectionManager;
import src.tools.OutputText;

/**
 * Clears collection.
 */
public class ClearCommand implements Command {
    /**
     * Clears collection.
     */
    @Override
    public void execute(String... args) {
        CollectionManager.clear();
        OutputText.result("Cleared");
    }
}
