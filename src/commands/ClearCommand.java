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
    public void execute(String mode, String[] line, String... args) {
        CollectionManager.clear();
        OutputText.result("Cleared");
    }
}
