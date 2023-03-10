package src.commands;

import src.collectionClasses.CollectionManager;
import src.tools.OutputText;

/**
 * Removes the first object in collection.
 */
public class RemoveFirstCommand implements Command {
    /**
     * Removes the first object in collection.
     */
    @Override
    public void execute(String mode, String... args) {
        if (CollectionManager.length() > 0) {
            CollectionManager.remove_first();
            OutputText.result("RemovedFirst");
        }
        else {OutputText.result("Empty");}
    }
}
