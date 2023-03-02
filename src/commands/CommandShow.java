package src.commands;

import src.collectionClasses.CollectionManager;
import src.tools.OutputText;

/**
 * Prints all objects in collection
 */
public class CommandShow {

    /**
     * Prints all objects in collection
     */
    public static void execute() {
        if (CollectionManager.length() > 0) {
            for (int i = 0; i < CollectionManager.length(); i++) {
                CollectionManager.element(CollectionManager.getDragonByIndex(i));
            }
        } else {
            OutputText.result("Empty");
        }
        System.out.println();
    }
}
