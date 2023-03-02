package src.commands;

import src.collectionClasses.CollectionManager;
import src.tools.OutputText;

/**
 * Prints the first object in collection if it is not empty.
 */
public class CommandHead {

    /**
     * Prints the first object in collection if it is not empty.
     */
    public static void execute() {
        if (CollectionManager.length() > 0) {
            CollectionManager.element(CollectionManager.getDragonByIndex(0));
        } else {
            OutputText.result("Empty");
        }
    }
}
