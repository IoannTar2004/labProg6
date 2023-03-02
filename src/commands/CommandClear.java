package src.commands;

import src.collectionClasses.CollectionManager;
import src.tools.OutputText;

/**
 * Clears collection.
 */
public class CommandClear {
    /**
     * Clears collection.
     */
    public static void execute() {
        CollectionManager.clear();
        OutputText.result("Cleared");
    }
}
